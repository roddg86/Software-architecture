package com.github.roddg86.hw;

/**
 * RESP API приложение
 *
 * на примере книги
 *
 * http://localhost:8080/books
 * http://localhost:8080/books/1
 *
 * запросы через powerShell:
 *
 * Invoke-WebRequest -Uri http://localhost:8080/books -Method POST
 *
 * Invoke-WebRequest -Uri http://localhost:8080/books -Method GET
 *
 * Invoke-WebRequest -Uri http://localhost:8080/books/1 -Method GET
 *
 * Invoke-WebRequest -Uri http://localhost:8080/books/1 -Method DELETE
 *
 * Invoke-RestMethod -Uri "http://localhost:8080/books/1" -Method PUT -ContentType "application/json" -Body '{"title": "NewBook", "author": "NewAutor", "year": 2022}'
 *
 */

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    // Эмулируем базу данных с использованием списка в памяти.
    private static List<Book> books = new ArrayList<>();
    private static AtomicInteger idGenerator = new AtomicInteger(1); // Генератор ID для книг.

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/books", new BookHandler());
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class BookHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Проверяем, является ли метод запроса "GET"
            if ("GET".equals(exchange.getRequestMethod())) {
                // Проверяем, содержит ли запрос путь "/books"
                if ("/books".equals(exchange.getRequestURI().getPath())) {
                    // Если да, то мы возвращаем список всех книг

                    // Преобразуем список книг в строковое представление
                    String responseBody = books.toString();

                    // Отправляем HTTP-ответ со статусным кодом 200 (OK)
                    // и длиной тела ответа
                    exchange.sendResponseHeaders(200, responseBody.length());

                    // Записываем тело ответа в выходной поток
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBody.getBytes());
                    }
                } else {
                    // Иначе, проверяем, содержит ли запрос путь "/books/{id}"
                    String[] pathParts = exchange.getRequestURI().getPath().split("/");
                    if (pathParts.length == 3 && "books".equals(pathParts[1])) {
                        // Если да, то получаем идентификатор книги из пути
                        int bookId = Integer.parseInt(pathParts[2]);

                        // Ищем книгу по идентификатору
                        Book book = findBookById(bookId);

                        // Проверяем, найдена ли книга
                        if (book != null) {
                            // Преобразуем книгу в строковое представление
                            String responseBody = book.toString();

                            // Отправляем HTTP-ответ со статусным кодом 200 (OK)
                            // и длиной тела ответа
                            exchange.sendResponseHeaders(200, responseBody.length());

                            // Записываем тело ответа в выходной поток
                            try (OutputStream os = exchange.getResponseBody()) {
                                os.write(responseBody.getBytes());
                            }
                        }
                    }
                }
            } else if ("POST".equals(exchange.getRequestMethod())) {
                // Добавляем новую книгу.
                int newId = idGenerator.getAndIncrement();
                Book newBook = new Book(newId, "Book" + newId, "Author" + newId, 2021);
                books.add(newBook);
                String responseBody = "Book added: " + newBook;
                exchange.sendResponseHeaders(201, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                String[] pathParts = exchange.getRequestURI().getPath().split("/");
                if (pathParts.length == 3 && "books".equals(pathParts[1])) {
                    int bookId = Integer.parseInt(pathParts[2]);
                    Book book = findBookById(bookId);
                    if (book != null) {
                        // Обновляем информацию о книге
                        String requestBody = new String(exchange.getRequestBody().readAllBytes());
                        JSONObject json = new JSONObject(requestBody);
                        if (json.has("title")) {
                            book.setTitle(json.getString("title"));
                        }
                        if (json.has("author")) {
                            book.setAuthor(json.getString("author"));
                        }
                        if (json.has("year")) {
                            book.setYear(json.getInt("year"));
                        }
                        String responseBody = "Book updated: " + book;
                        exchange.sendResponseHeaders(200, responseBody.length());
                        try (OutputStream os = exchange.getResponseBody()) {
                            os.write(responseBody.getBytes());
                        }
                    }
                }
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                // Удаляем книгу по ID.
                String[] pathParts = exchange.getRequestURI().getPath().split("/");
                if (pathParts.length == 3) {
                    int bookId = Integer.parseInt(pathParts[2]);
                    books.removeIf(book -> book.getId() == bookId);
                    String responseBody = "Book with ID " + bookId + " removed.";
                    exchange.sendResponseHeaders(200, responseBody.length());
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBody.getBytes());
                    }
                }
            } else {
                String responseBody = "Method not allowed";
                exchange.sendResponseHeaders(405, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        }
    }

    // Метод для поиска книги по ее ID.
    private static Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    static class Book {
        private int id;
        private String title;
        private String author;
        private int year;

        // Конструктор по умолчанию, необходим для Jackson
        public Book() {
        }

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public Book(int id, String title, String author, int year) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.year = year;
        }

        // Геттеры и сеттеры
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    '}';
        }

    }
}

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Простой http сервер
 *
 * http://localhost:8080/books
 */

public class SimpleServer {

    // Главный метод программы, который запускается при старте
    public static void main(String[] args) throws Exception {
        // Создаем HTTP-сервер, который будет слушать порт 8080
        // Это означает, что наш сервер готов принимать HTTP-запросы и отправлять HTTP-ответы.
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Настраиваем сервер так, чтобы при запросе к URL "/books" вызывался метод "handle"
        // Здесь мы создаем ресурс "/books". В контексте онлайн-библиотеки это может быть список всех книг.
        server.createContext("/books", new BookHandler());

        // Запускаем сервер
        server.start();
    }

    // Обработчик для URL "/books"
    static class BookHandler implements HttpHandler {

        // Метод обработки HTTP-запросов
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Получаем метод запроса (GET, POST, и т.д.)
            String requestMethod = exchange.getRequestMethod();

            // Если метод запроса - GET
            if ("GET".equalsIgnoreCase(requestMethod)) {
                // Создаем строку с ответом
                // Это пример операции чтения в REST (Read)
                String responseBody = "List of books";

                // Устанавливаем заголовок ответа и код статуса 200 (ОК)
                // Код 200 означает, что запрос был успешно обработан
                exchange.sendResponseHeaders(200, responseBody.getBytes().length);

                // Получаем выходной поток для записи ответа
                // Здесь мы устанавливаем тип содержимого ответа как "text/plain"
                OutputStream os = exchange.getResponseBody();

                // Записываем тело ответа и закрываем поток
                os.write(responseBody.getBytes());
                os.close();
            } else {
                // Если метод запроса не GET, отправляем код статуса 405 (Метод не разрешен)
                // Это означает, что такой тип запроса не поддерживается нашим сервером для данного ресурса
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }
}

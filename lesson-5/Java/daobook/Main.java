package daobook;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO)
 *
 * структура паттерна DAO
 */

// Интерфейс BookDAO определяет операции, которые мы хотим поддерживать для доступа к данным книг.
interface BookDAO {
    List<Book> getAllBooks();
    Book getBook(String isbn);
    void updateBook(Book book);
    void deleteBook(Book book);
}

// Класс Book представляет объект данных книги.
class Book {
    private String isbn;
    private String title;
    private String author;
// методы getters и setters здесь
}

// Реализация BookDAO для работы с базой данных SQL.
class BookDAOImpl implements BookDAO {
    private Connection dbConnection;

    public BookDAOImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
// Здесь мы используем dbConnection для получения всех книг из базы данных и возвращаем их как список объектов Book.
        return new ArrayList<>(books);
    }

    @Override
    public Book getBook(String isbn) {
// Здесь мы используем dbConnection для получения книги с заданным ISBN из базы данных и возвращаем её как объект Book.
        return null;
    }

    @Override
    public void updateBook(Book book) {
// Здесь мы используем dbConnection и данные объекта book для обновления книги в базе данных.
    }

    @Override
    public void deleteBook(Book book) {
// Здесь мы используем dbConnection и данные объекта book для удаления книги из базы данных.
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

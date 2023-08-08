package bookstore.data.bookrepository;

import bookstore.domain.Book;

import java.util.List;

// Интерфейс для репозитория книг
interface BookRepository {
    // Метод для добавления книги
    void addBook(Book book);

    // Метод для удаления книги
    void removeBook(Book book);

    // Метод для обновления книги
    void updateBook(Book book);

    // Метод для получения всех книг
    List<Book> getAllBooks();

    // Метод для вывода всех книг
    void printAllBooks(BookRepository bookRepository);

}

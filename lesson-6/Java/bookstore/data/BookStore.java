package bookstore.data;

import bookstore.domain.Book;

import java.util.ArrayList;
import java.util.List;

// Класс, реализующий хранилище книг с использованием коллекций
class BookStore {
    private List<Book> books;

    /**
     * Конструктор класса BookStore.
     * Инициализирует пустой список книг.
     */
    public BookStore() {
        books = new ArrayList<>();
    }

    /**
     * Добавляет книгу в BookStore.
     * 
     * @param book Книга, которую нужно добавить.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Удаляет книгу из BookStore.
     * 
     * @param book Книга, которую нужно удалить.
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Получает все книги из BookStore.
     * 
     * @return Список всех книг в BookStore.
     */
    public List<Book> getAllBooks() {
        return books;
    }
}

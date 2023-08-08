package bookstore.presentation;

import bookstore.data.bookrepository.InMemoryBookRepository;
import bookstore.domain.Book;

public class Main {
    public static void main(String[] args) {

        InMemoryBookRepository bookRepository = new InMemoryBookRepository();

        // Добавляем книги в хранилище
        Book book3 = new Book("3", "Clean Code", "Robert C. Martin", 34.99);
        Book book4 = new Book("4", "Effective Java", "Joshua Bloch", 29.99);
        bookRepository.addBook(book3);
        bookRepository.addBook(book4);

        // Удаляем книги из хранилища
        bookRepository.removeBook(book4);

        // Создаем новый экземпляр с обновлением
        book3 = new Book("3", "Clean Code", "Robert C. Martin", 70.99);

        // Обновляем книгу в хранилище
        bookRepository.updateBook(book3);

        // Получаем список всех книг в хранилище
        bookRepository.printAllBooks(bookRepository);
    }
}

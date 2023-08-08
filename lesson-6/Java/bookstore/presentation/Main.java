package bookstore.presentation;

import bookstore.data.bookrepository.BookOperationHandler;
import bookstore.data.bookrepository.BookRepository;
import bookstore.data.bookrepository.InMemoryBookRepository;

public class Main {

    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();

        BookOperationHandler operationHandler = new BookOperationHandler(bookRepository);

        operationHandler.addBook("3", "Clean Code", "Robert C. Martin", 34.99);
        operationHandler.addBook("4", "Effective Java", "Joshua Bloch", 29.99);

        operationHandler.removeBook("4");

        operationHandler.updateBook("3", "Clean Code", "Robert C. Martin", 70.99);

        operationHandler.printAllBooks();
    }
}

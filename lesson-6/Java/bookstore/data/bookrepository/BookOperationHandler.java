package bookstore.data.bookrepository;

import bookstore.domain.Book;

public class BookOperationHandler {
    private BookRepository bookRepository;

    public BookOperationHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String id, String title, String author, double price) {
        Book book = new Book(id, title, author, price);
        bookRepository.addBook(book);
    }

    public void removeBook(String id) {
        Book book = bookRepository.getAllBooks().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (book != null) {
            bookRepository.removeBook(book);
        }
    }

    public void updateBook(String id, String title, String author, double price) {
        Book updatedBook = new Book(id, title, author, price);
        bookRepository.updateBook(updatedBook);
    }

    public void printAllBooks() {
        bookRepository.printAllBooks();
    }
}

package bookstore.data.bookrepository;

import bookstore.domain.Book;

import java.util.ArrayList;
import java.util.List;

// Класс, реализующий интерфейс BookRepository
public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    /**
     * Конструктор класса InMemoryBookRepository.
     * Инициализирует пустой список книг.
     */
    public InMemoryBookRepository() {
        books = new ArrayList<>();
    }

    /**
     * Добавляет книгу в репозиторий.
     *
     * @param book Книга, которую необходимо добавить.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Удаляет книгу из репозитория.
     *
     * @param book Книга, которую необходимо удалить.
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Обновляет информацию о книге в репозитории.
     * Ищет книгу с тем же ID и заменяет ее на новую книгу.
     *
     * @param book Обновленная книга.
     */
    public void updateBook(Book book) {
        boolean found = false;
        int index = 0;
        while (!found && index < books.size()) {
            Book currentBook = books.get(index);
            if (currentBook.getId().equals(book.getId())) {
                books.set(index, book);
                found = true;
            }
            index++;
        }
    }

    /**
     * Получает все книги из репозитория.
     *
     * @return Список всех книг.
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Выводит информацию о всех книгах на экран.
     *
     * @param bookRepository Репозиторий книг, из которого нужно получить книги.
     */
    public void printAllBooks(BookRepository bookRepository) {
        List<Book> allBooks = bookRepository.getAllBooks();
        for (Book book : allBooks) {
            System.out.println(
                    "id: " + book.getId()
                            + ", Книга: " + book.getTitle()
                            + ", Автор: " + book.getAuthor()
                            + ", Цена: $" + book.getPrice());
        }
    }
}

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
     * @param updatedBook Обновленная книга.
     */
    @Override
    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId().equals(updatedBook.getId())) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    /**
     * Получает все книги из репозитория.
     *
     * @return Список всех книг.
     */
    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Выводит информацию о всех книгах на экран.
     *
     */
    @Override
    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - $" + book.getPrice());
        }
    }
}

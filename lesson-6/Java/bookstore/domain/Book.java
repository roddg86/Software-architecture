package bookstore.domain;

// Класс представляющий книгу
public class Book {
    // Уникальный идентификатор книги
    private String id;

    // Название книги
    private String title;

    // Автор книги
    private String author;

    // Цена книги
    private double price;

    /**
     * Конструирует объект книги с заданным идентификатором, названием, автором и ценой.
     *
     * @param id     идентификатор книги
     * @param title  название книги
     * @param author автор книги
     * @param price  цена книги
     */
    public Book(String id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Возвращает идентификатор книги.
     *
     * @return идентификатор книги
     */
    public String getId() {
        return id;
    }

    /**
     * Возвращает название книги.
     *
     * @return название книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает автора книги.
     *
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Возвращает цену книги.
     *
     * @return цена книги
     */
    public double getPrice() {
        return price;
    }

    /**
     * Устанавливает идентификатор книги.
     *
     * @param id идентификатор книги
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Устанавливает название книги.
     *
     * @param title название книги
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Устанавливает автора книги.
     *
     * @param author автор книги
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Устанавливает цену книги.
     *
     * @param price цена книги
     */
    public void setPrice(double price) {
        this.price = price;
    }
}

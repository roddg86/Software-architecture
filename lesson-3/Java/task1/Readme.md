### Принцип единственной ответственности

Задача сделать рефакторинг кода на основании принципа единственной ответственности

```java
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void save() {
        System.out.println("Сохранение информации о книге '" + title + "' в базе данных.");
    }

    public void print() {
        System.out.println("Печать книги '" + title + "' автора '" + author + "'.");
    }
}

public class datamapper {
    public static void main(String[] args) {
        Book book = new Book("Властелин Колец", "Толкин");
        book.save();
        book.print();
    }
}
```
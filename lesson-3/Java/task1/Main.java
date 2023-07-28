package task1;
public class Main {
    public static void main(String[] args) {
        Book book = new Book("Властелин Колец", "Толкин");
        Print print = new Print();
        print.print(book);
        Save save = new Save();
        save.save(book);
    }
}

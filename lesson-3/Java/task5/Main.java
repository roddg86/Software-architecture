package task5;

public class Main {
    public static void main(String[] args) {
        Printable myText = new Text("Hello, world!");
        Printer myPrinter = new Printer();
        myPrinter.print(myText);
    }
}

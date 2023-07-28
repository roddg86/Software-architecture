### Принцип инверсии зависимостей

В этом примере класс Printer зависит от конкретного класса Text.

```java
public class Text {
    String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

public class Printer {
    public void print(Text text) {
        System.out.println(text.getText());
    }
}

public class Main {
    public static void main(String[] args) {
        Text myText = new Text("Hello, world!");
        Printer myPrinter = new Printer();
        myPrinter.print(myText);
    }
}
```
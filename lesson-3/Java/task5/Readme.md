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

public class datamapper {
    public static void main(String[] args) {
        Text myText = new Text("Hello, world!");
        Printer myPrinter = new Printer();
        myPrinter.print(myText);
    }
}
```

### Решение
[Принцип инверсии зависимостей](#Принцип-инверсии-зависимостей)

Чтобы переписать код согласно принципу инверсии зависимостей, 
необходимо ввести абстракцию между классами Text и Printer.  
Для этого можно создать интерфейс Printable, 
который будет определять метод getText().  
Затем класс Text должен реализовывать этот интерфейс.  
Теперь класс Printer будет принимать объекты типа Printable 
вместо конкретного класса Text.  
Класс Printer зависит от абстракции Printable 
вместо конкретной реализации Text.
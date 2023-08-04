### Принцип открытости закрытости

Сделать рефакторинг кода на основании принципа открытости закрытости

```java
public class Greeting {
    private String type;

    public Greeting(String type) {
        this.type = type;
    }

    public void greet() {
        if ("formal".equals(type)) {
            System.out.println("Добро пожаловать, уважаемый гость!");
        } else if ("informal".equals(type)) {
            System.out.println("Привет, друг!");
        }
    }
}

public class datamapper {
    public static void main(String[] args) {
        Greeting greeting = new Greeting("informal");
        greeting.greet();
    }
}

```
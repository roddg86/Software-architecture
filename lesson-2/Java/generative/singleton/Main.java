package generative.singleton;
public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething(); // Выведет: "Вызван метод doSomething()"

        Singleton singleton2 = Singleton.getInstance();
        singleton2.doSomething(); // Выведет: "Вызван метод doSomething()"
    }
}

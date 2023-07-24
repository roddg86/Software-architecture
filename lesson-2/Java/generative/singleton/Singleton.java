package generative.singleton;

public class Singleton {
    // Статическое поле для хранения единственного экземпляра класса
    private static Singleton instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне класса
    private Singleton() {
    }

    // Статический метод для получения единственного экземпляра класса
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Дополнительные методы и свойства класса (необязательно)
    public void doSomething() {
        System.out.println("Вызван метод doSomething()");
    }
}

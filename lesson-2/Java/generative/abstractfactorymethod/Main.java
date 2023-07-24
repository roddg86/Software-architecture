package generative.abstractfactorymethod;

// Интерфейс для продукта
interface Product {
    void display();
}

// Конкретный класс продукта
class ConcreteProduct implements Product {
    @Override
    public void display() {
        System.out.println("Это конкретный продукт.");
    }
}

// Абстрактный класс фабрики
abstract class Creator {
    // Фабричный метод
    public abstract Product createProduct();
}

// Конкретный класс фабрики
class ConcreteCreator extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}

// Клиентский код
public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct();
        product.display();  // Выведет: "Это конкретный продукт."
    }
}

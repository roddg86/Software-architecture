package generative.prototype;

// Абстрактный класс Прототипа
abstract class Prototype implements Cloneable {
    public abstract Prototype clone();
}

// Конкретный класс Прототипа
class ConcretePrototype extends Prototype {
    private String property;

    public ConcretePrototype(String property) {
        this.property = property;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(property);
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}

// Клиентский код
public class Main {
    public static void main(String[] args) {
        // Создаем и инициализируем прототип
        ConcretePrototype prototype = new ConcretePrototype("Пример");

        // Создаем новый объект путем клонирования прототипа
        ConcretePrototype clone1 = (ConcretePrototype) prototype.clone();
        System.out.println("Клон 1: " + clone1.getProperty());

        // Меняем свойство клонированного объекта
        clone1.setProperty("Измененный пример");
        System.out.println("Клон 1 (после изменения): " + clone1.getProperty());

        // Создаем еще один новый объект путем клонирования прототипа
        ConcretePrototype clone2 = (ConcretePrototype) prototype.clone();
        System.out.println("Клон 2: " + clone2.getProperty());
    }
}

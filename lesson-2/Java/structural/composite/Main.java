package structural.composite;

import java.util.ArrayList;
import java.util.List;

// Интерфейс компонента
interface Component {
    void operation();
}

// Конкретный компонент
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Выполнение операции для Leaf " + name);
    }
}

// Компоновщик (Composite)
class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Выполнение операции для Composite");
        for (Component component : components) {
            component.operation();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Создание листьев
        Component leaf1 = new Leaf("Лист 1");
        Component leaf2 = new Leaf("Лист 2");

        // Создание компоновщиков
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        // Добавление листьев в компоновщик 1
        composite1.addComponent(leaf1);
        composite1.addComponent(leaf2);

        // Добавление компоновщика 1 в компоновщик 2
        composite2.addComponent(composite1);

        // Выполнение операций
        leaf1.operation();       // Выведет: "Выполнение операции для Leaf Лист 1"
        leaf2.operation();       // Выведет: "Выполнение операции для Leaf Лист 2"
        composite1.operation();  // Выведет: "Выполнение операции для Composite", "Выполнение операции для Leaf Лист 1", "Выполнение операции для Leaf Лист 2"
        composite2.operation();  // Выведет: "Выполнение операции для Composite", "Выполнение операции для Leaf Лист 1", "Выполнение операции для Leaf Лист 2"
    }
}

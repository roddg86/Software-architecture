package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// Интерфейс для наблюдателя
interface Observer {
    void update();
}

// Интерфейс для субъекта (наблюдаемого объекта)
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Конкретный наблюдатель
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + ": Получено уведомление об изменениях!");
    }
}

// Конкретный субъект (наблюдаемый объект)
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // Метод, который вызывается при изменении состояния субъекта
    public void doSomething() {
        // Логика изменения состояния субъекта
        // ...
        // Уведомляем наблюдателей об изменениях
        notifyObservers();
    }
}
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver("Наблюдатель 1");
        ConcreteObserver observer2 = new ConcreteObserver("Наблюдатель 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Вызываем метод, который меняет состояние субъекта и уведомляет наблюдателей
        subject.doSomething();
    }
}

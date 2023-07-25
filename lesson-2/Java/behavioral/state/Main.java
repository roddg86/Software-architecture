package behavioral.state;

/**
 * Состояние — это поведенческий паттерн проектирования, который позволяет
 * объектам менять поведение в зависимости от своего состояния. Извне
 * создаётся впечатление, что изменился класс объекта.
 */


/**
 * Абстрактный класс, представляющий состояние - предоставляет базовый класс
 * для различных состояний системы светофора.
 * Каждое состояние может иметь свою собственную
 * реализацию методов nextState и previousState,
 * определяющих поведение светофора в данном состоянии.
 * Метод setTrafficLight используется
 * для связывания объекта светофора с состоянием.
 */
abstract class State {
    protected TrafficLight trafficLight;

    // Метод для установки объекта светофора
    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    // Метод для перехода к следующему состоянию
    public abstract void nextState();

    // Метод для перехода к предыдущему состоянию
    public abstract void previousState();
}

// Класс, представляющий светофор
class TrafficLight {
    private State state;

    // Конструктор для инициализации светофора состоянием
    public TrafficLight(State state) {
        setState(state);
    }

    // Метод для установки состояния светофора
    public void setState(State state) {
        this.state = state;
        state.setTrafficLight(this);
    }

    // Метод для перехода к следующему состоянию
    public void nextState() {
        state.nextState();
    }

    // Метод для перехода к предыдущему состоянию
    public void previousState() {
        state.previousState();
    }
}

// Класс, представляющий зеленое состояние светофора
class GreenState extends State {
    // Метод для перехода к следующему состоянию
    public void nextState() {
        System.out.println("Переход из зеленого в желтый");
        trafficLight.setState(new YellowState());
    }

    // Метод для перехода к предыдущему состоянию
    public void previousState() {
        System.out.println("Зеленый цвет");
    }
}

// Класс, представляющий желтое состояние светофора
class YellowState extends State {
    // Метод для перехода к следующему состоянию
    public void nextState() {
        System.out.println("Переход из желтого в красный");
        trafficLight.setState(new RedState());
    }

    // Метод для перехода к предыдущему состоянию
    public void previousState() {
        System.out.println("Переход из желтого в зеленый");
        trafficLight.setState(new GreenState());
    }
}

// Класс, представляющий красное состояние светофора
class RedState extends State {
    // Метод для перехода к следующему состоянию
    public void nextState() {
        System.out.println("Красный цвет");
    }

    // Этот метод выполняет переход светофора в предыдущее состояние.
    public void previousState() {
        // Выводит сообщение о переходе с красного на желтый цвет.
        System.out.println("Из красного в желтый цвет");

        // Устанавливает состояние светофора на YellowState.
        trafficLight.setState(new YellowState());
    }

}

public class Main {
    public static void main(String[] args) {
        // Создаем новый объект TrafficLight с начальным состоянием "Желтый"
        TrafficLight trafficLight = new TrafficLight(new YellowState());

        // Переходим к следующему состоянию светофора
        trafficLight.nextState();

        // Переходим к следующему состоянию еще раз
        trafficLight.nextState();

        // Переходим к предыдущему состоянию светофора
        trafficLight.previousState();

        // Переходим к предыдущему состоянию еще раз
        trafficLight.previousState();

        // Переходим к предыдущему состоянию еще один раз
        trafficLight.previousState();
    }
}

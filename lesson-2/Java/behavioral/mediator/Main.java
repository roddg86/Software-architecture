package behavioral.mediator;

/**
 * Посредник — это поведенческий паттерн проектирования, который позволяет
 * уменьшить связанность множества классов между собой, благодаря
 * перемещению этих связей в один класс-посредник.
 */

// Интерфейс посредника, который определяет контракт для общения между сотрудниками
interface IMediator {
    void notify(Employee emp, String msg);
}

// Абстрактный базовый класс для всех сотрудников
abstract class Employee {
    protected IMediator mediator;

    // Конструктор, принимающий объект посредника
    public Employee(IMediator mediator) {
        this.mediator = mediator;
    }

    // Метод для установки объекта посредника
    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }
}

// Конкретный класс сотрудника - Дизайнер
class Designer extends Employee {
    private boolean isWorking;

    // Конструктор, принимающий объект посредника
    public Designer(IMediator mediator) {
        super(mediator);
    }

    // Метод для выполнения работы и уведомления посредника
    public void executeWork() {
        System.out.println("Выполняется работа дизайнера");
        mediator.notify(this, "Дизайнер проектирует проект");
    }

    // Метод для установки состояния работы дизайнера
    public void setWorking(boolean state) {
        isWorking = state;
        if (state)
            System.out.println("Дизайнер освобожден от работы");
        else
            System.out.println("Дизайнер занят");
    }

}

// Конкретный класс сотрудника - Директор
class Director extends Employee {
    private String text;

    // Конструктор, принимающий объект посредника
    public Director(IMediator mediator) {
        super(mediator);
    }

    // Метод для передачи команды директору и уведомления посредника
    public void giveCommand(String text) {
        this.text = text;
        mediator.notify(this, text);
        if (text == "")
            System.out.println("Директор знает, что дизайнер уже работает");
        else
            System.out.println("Директор дал команду: " + text);
        mediator.notify(this, text);
    }
}

// Конкретный класс посредника - Контроллер
class Controller implements IMediator {
    private Designer designer;
    private Director director;

    // Конструктор, принимающий экземпляры классов Designer и Director
    public Controller(Designer designer, Director director) {
        this.designer = designer;
        this.director = director;

        // Установка посредника для сотрудников
        designer.setMediator(this);
        director.setMediator(this);
    }

    // Метод для уведомления посредника о событии и выполнения соответствующих
    // действий
    public void notify(Employee emp, String msg) {
        if (emp instanceof Director) {
            if (msg.equals(""))
                designer.setWorking(false);
            else
                designer.setWorking(true);
        }
        if (emp instanceof Designer)
            director.giveCommand("");
    }
}

// Это основной класс, который служит точкой входа в программу
public class Main {
    public static void main(String[] args) {
        // Создаем новый экземпляр класса Designer с параметром null
        Designer designer = new Designer(null);

        // Создаем новый экземпляр класса Director с параметром null
        Director director = new Director(null);

        // Создаем новый экземпляр класса Controller с объектами designer и director в
        // качестве параметров
        Controller mediator = new Controller(designer, director);

        // Вызываем метод giveCommand на объекте director, передавая команду
        // "Проектировать проект" в качестве параметра
        director.giveCommand("Проектировать проект");

        // Выводим пустую строку
        System.out.println();

        // Вызываем метод executeWork на объекте designer
        designer.executeWork();
    }
}

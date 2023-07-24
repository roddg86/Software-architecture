package structural.facade;

// Класс для выполнения задачи A
class TaskA {
    public void execute() {
        System.out.println("Выполнение задачи A");
    }
}

// Класс для выполнения задачи B
class TaskB {
    public void execute() {
        System.out.println("Выполнение задачи B");
    }
}

// Класс для выполнения задачи C
class TaskC {
    public void execute() {
        System.out.println("Выполнение задачи C");
    }
}

// Фасад
class Facade {
    private TaskA taskA;
    private TaskB taskB;
    private TaskC taskC;

    public Facade() {
        taskA = new TaskA();
        taskB = new TaskB();
        taskC = new TaskC();
    }

    public void doAllTasks() {
        taskA.execute();
        taskB.execute();
        taskC.execute();
    }
}
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doAllTasks();
    }
}
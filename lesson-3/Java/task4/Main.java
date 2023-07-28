package task4;

public class Main {
    public static void main(String[] args) {
        //Workable worker = new RobotWorker();

        HumanWorker worker = new HumanWorker();
        worker.work();

        // Проверка типа объекта перед вызовом метода eat()
        if (worker instanceof Eatable) {
            Eatable eatableWorker = (Eatable) worker;
            worker.eat();
        } else {
            throw new UnsupportedOperationException("Роботы не едят!");
        }
    }
}


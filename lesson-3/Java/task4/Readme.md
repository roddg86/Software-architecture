### Принцип сегрегации интерфейса

В этом примере класс RobotWorker не использует и не должен использовать метод eat(), поэтому он нарушает принцип сегрегации интерфейса.

```java
public interface Worker {
void work();
void eat();
}

public class HumanWorker implements Worker {
public void work() {
System.out.println("Человек работает");
}

public void eat() {
    System.out.println("Человек ест");
}
}

public class RobotWorker implements Worker {
public void work() {
System.out.println("Робот работает");
}

public void eat() {
    throw new UnsupportedOperationException("Роботы не едят!");
}
}

public class Main {
public static void main(String[] args) {
Worker worker = new RobotWorker();
worker.work();
worker.eat(); // Здесь возникнет исключение UnsupportedOperationException
}
}

```
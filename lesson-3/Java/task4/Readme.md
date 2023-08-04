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

public class datamapper {
    public static void main(String[] args) {
        Worker worker = new RobotWorker();
        worker.work();
        worker.eat(); // Здесь возникнет исключение UnsupportedOperationException
    }
}

```

### Решение
[Принцип сегрегации интерфейса](#Принцип-сегрегации-интерфейса)

Чтобы исправить код согласно принципу разделения интерфейсов,
нам потребуется разделить интерфейс Worker на два отдельных интерфейса 
Workable и Eatable.   
Затем классы HumanWorker и RobotWorker должны реализовывать соответствующие интерфейсы.  
Класс HumanWorker реализует оба интерфейса, 
а класс RobotWorker реализует только интерфейс Workable.  
В методе main() проверяем тип объекта, чтобы определить, может ли он есть, 
и вызываем соответствующий метод eat().

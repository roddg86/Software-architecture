package behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Этот интерфейс IVisitor используется для реализации паттерна
 * проектирования "Посетитель" (Visitor pattern) в объектно-ориентированном
 * программировании.
 *
 * Паттерн "Посетитель" позволяет добавлять новые операции к группе объектов,
 * не изменяя их классы. В данном случае, интерфейс IVisitor определяет методы
 * visit,
 * которые могут быть реализованы различными классами,
 * чтобы выполнить специфичные действия при посещении
 * объектов типа Zoo, Cinema и Circus.
 *
 * Таким образом, этот интерфейс может быть использован для
 * создания различных визиторов (посетителей),
 * которые могут выполнять различные операции с объектами,
 * не изменяя самих объектов.
 */
interface IVisitor {
    void visit(Zoo zoo); // Метод Visitor для посещения Zoo

    void visit(Cinema cinema); // Метод Visitor для посещения Cinema

    void visit(Circus circus); // Метод Visitor для посещения Circus
}

/**
 * Определяем интерфейс Place
 *
 * Этот интерфейс представляет место.
 * Он определяет метод с именем 'accept', который используется для принятия
 * посетителя.
 * Посетитель - это объект, который может выполнять операции над местом.
 * 
 * Примечание: Метод 'accept' принимает аргумент типа 'IVisitor', который
 * представляет интерфейс посетителя.
 * Метод 'accept' отвечает за вызов соответствующего метода объекта посетителя.
 * 
 * Использование:
 * - Реализуйте этот интерфейс в классе, чтобы создать место, которое может быть
 * посещено посетителем.
 * - Передайте экземпляр посетителя в метод 'accept', чтобы выполнить операции
 * над местом.
 */
interface IPlace {
    void accept(IVisitor visitor);
}

// Реализация класса Zoo, который реализует интерфейс IPlace
class Zoo implements IPlace {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this); // Вызываем метод visit посетителя для Zoo
    }
}

// Реализация класса Cinema, который реализует интерфейс IPlace
class Cinema implements IPlace {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this); // Вызываем метод visit посетителя для Cinema
    }
}

// Реализация класса Circus, который реализует интерфейс IPlace
class Circus implements IPlace {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this); // Вызываем метод visit посетителя для Circus
    }
}

// Реализация интерфейса Visitor
class HolidayMaker implements IVisitor {
    public String value; // Переменная для хранения результата посещения

    // Реализация метода visit для Zoo
    public void visit(Zoo zoo) {
        value = "Слон в зоопарке"; // Устанавливаем значение "Слон в зоопарке"
    }

    // Реализация метода visit для Cinema
    public void visit(Cinema cinema) {
        value = "Кино властелин колец"; // Устанавливаем значение "Кино властелин колец"
    }

    // Реализация метода visit для Circus
    public void visit(Circus circus) {
        value = "Клоун в цирке"; // Устанавливаем значение "Клоун в цирке"
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем список для хранения различных мест
        List<IPlace> places = new ArrayList<>();

        // Добавляем различные места в список
        places.add(new Zoo());
        places.add(new Cinema());
        places.add(new Circus());

        // Итерируемся по каждому месту в списке
        for (IPlace place : places) {
            // Создаем нового посетителя (HolidayMaker) для каждого места
            HolidayMaker visitor = new HolidayMaker();

            // Принимаем посетителя на месте, что позволяет выполнить некоторое действие
            place.accept(visitor);

            // Печатаем значение посетителя после выполнения действия
            System.out.println(visitor.value);
        }
    }
}

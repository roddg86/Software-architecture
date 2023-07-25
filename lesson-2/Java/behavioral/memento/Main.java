package behavioral.memento;

/**
 * Снимок — это поведенческий паттерн проектирования,
 * который позволяет сохранять и восстанавливать прошлые состояния объектов,
 * не раскрывая подробностей их реализации.
 */

import java.util.Stack;

// Этот интерфейс определяет методы, которые должен иметь объект Memento
interface IMemento {
    int getDollars(); // Возвращает количество долларов

    int getEuro(); // Возвращает количество евро
}

/**
 * Этот класс ExchangeMemento представляет объект, который хранит состояние объекта Exchange.
 * Он имеет следующие функции:
 *
 * В конструкторе ExchangeMemento инициализируются значения количества долларов и евро.
 * Метод getDollars возвращает количество долларов, сохраненное в объекте ExchangeMemento.
 * Метод getEuro возвращает количество евро, сохраненное в объекте ExchangeMemento.
 * Этот класс используется в методах save и restore класса Exchange для сохранения и
 * восстановления состояния объекта Exchange. Когда вызывается метод save,
 * создается новый объект ExchangeMemento, в котором сохраняются текущие значения
 * долларов и евро объекта Exchange. Затем этот объект ExchangeMemento передается в метод restore,
 * чтобы восстановить состояние объекта Exchange из сохраненного объекта ExchangeMemento.
 *
 * Таким образом, класс ExchangeMemento служит для хранения и передачи состояния объекта Exchange.
 */
class ExchangeMemento implements IMemento {
    private int dollars; // Количество долларов
    private int euro; // Количество евро

    public ExchangeMemento(int dollars, int euro) {
        this.dollars = dollars;
        this.euro = euro;
    }

    public int getDollars() {
        return dollars;
    }

    public int getEuro() {
        return euro;
    }
}

/**
 * Этот класс представляет модель обмена валюты. Он имеет следующие функции:
 *
 * В конструкторе Exchange устанавливаются начальные значения количества долларов и евро.
 * Метод getDollars выводит текущее количество долларов.
 * Метод getEuro выводит текущее количество евро.
 * Метод sellDollars уменьшает количество долларов на 1, если оно больше 0.
 * Метод buyEuro увеличивает количество евро на 1.
 * Метод save создает и возвращает объект ExchangeMemento, который содержит текущее состояние объекта Exchange.
 * Метод restore восстанавливает состояние объекта Exchange с использованием объекта ExchangeMemento.
 * Этот класс позволяет отслеживать и изменять количество долларов и евро в рамках обмена валюты.
 */
class Exchange {
    private int dollars; // Количество долларов
    private int euro; // Количество евро

    public Exchange(int dollars, int euro) {
        this.dollars = dollars;
        this.euro = euro;
    }

    public void getDollars() {
        System.out.println("Долларов: " + dollars); // Выводит текущее количество долларов
    }

    public void getEuro() {
        System.out.println("Евро: " + euro); // Выводит текущее количество евро
    }

    public void sellDollars() {
        if (dollars > 0) {
            --dollars; // Уменьшает количество долларов на 1
        }
    }

    public void buyEuro() {
        ++euro; // Увеличивает количество евро на 1
    }

    // Этот метод создает и возвращает Memento с текущим состоянием объекта Exchange
    public ExchangeMemento save() {
        return new ExchangeMemento(dollars, euro);
    }

    // Этот метод восстанавливает состояние объекта Exchange с использованием
    // Memento
    public void restore(IMemento exchangeMemento) {
        dollars = exchangeMemento.getDollars();
        euro = exchangeMemento.getEuro();
    }
}

// Этот класс представляет память, которая хранит историю Memento
class Memory {
    private Stack<IMemento> history; // Стек для хранения Memento
    Exchange exchange; // Объект Exchange

    public Memory(Exchange exchange) {
        this.exchange = exchange;
        history = new Stack<>();
    }

    // Этот метод сохраняет текущее состояние объекта Exchange, добавляя Memento в
    // стек
    public void save() {
        history.push(exchange.save());
    }

    // Этот метод восстанавливает состояние объекта Exchange, извлекая Memento из
    // стека
    public void restore() {
        if (history.isEmpty())
            return;
        exchange.restore(history.pop());
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр класса Exchange с начальными значениями долларов и евро
        Exchange exchange = new Exchange(100, 200);

        // Создаем экземпляр класса Memory и передаем ему экземпляр Exchange
        Memory memory = new Memory(exchange);

        // Получаем текущие значения долларов и евро из экземпляра Exchange
        exchange.getDollars();
        exchange.getEuro();

        // Выводим сообщение о том, что будем продавать доллары и покупать евро
        System.out.println("-----Продажа доллара, покупка евро------");

        // Выполняем операции sellDollars и buyEuro на экземпляре Exchange
        exchange.sellDollars();
        exchange.buyEuro();

        // Получаем обновленные значения долларов и евро из экземпляра Exchange
        exchange.getDollars();
        exchange.getEuro();

        // Выводим сообщение о том, что будем сохранять состояние
        System.out.println("-----Сохранение состояния-----");

        // Сохраняем состояние экземпляра Exchange с помощью экземпляра Memory
        memory.save();

        // Выводим сообщение о том, что снова будем продавать доллары и покупать евро
        System.out.println("-----Продажа доллара, покупка евро------");

        // Выполняем операции sellDollars и buyEuro на экземпляре Exchange снова
        exchange.sellDollars();
        exchange.buyEuro();

        // Получаем обновленные значения долларов и евро из экземпляра Exchange
        exchange.getDollars();
        exchange.getEuro();

        // Выводим сообщение о том, что будем восстанавливать состояние
        System.out.println("-----Восстановление состояния-----");

        // Восстанавливаем состояние экземпляра Exchange с помощью экземпляра Memory
        memory.restore();

        // Получаем восстановленные значения долларов и евро из экземпляра Exchange
        exchange.getDollars();
        exchange.getEuro();
    }
}

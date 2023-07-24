package structural.decorator;

// Интерфейс для кофе
interface Coffee {
    double getCost();
    String getDescription();
}

// Конкретная реализация базового кофе
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Простой кофе";
    }
}

// Декоратор для добавления молока
class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", с молоком";
    }
}

// Декоратор для добавления шоколада
class ChocolateDecorator implements Coffee {
    private Coffee coffee;

    public ChocolateDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", с шоколадом";
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Простой кофе: " + simpleCoffee.getDescription() + ", стоимость: " + simpleCoffee.getCost());

        Coffee coffeeWithMilk = new MilkDecorator(simpleCoffee);
        System.out.println("Кофе с молоком: " + coffeeWithMilk.getDescription() + ", стоимость: " + coffeeWithMilk.getCost());

        Coffee coffeeWithMilkAndChocolate = new ChocolateDecorator(coffeeWithMilk);
        System.out.println("Кофе с молоком и шоколадом: " + coffeeWithMilkAndChocolate.getDescription() + ", стоимость: " + coffeeWithMilkAndChocolate.getCost());
    }
}



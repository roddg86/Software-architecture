package example6;

// Класс для сложения
class Addition {
    public int add(int a, int b) {
        return a + b;
    }
}

// Класс для вычитания
class Subtraction {
    public int subtract(int a, int b) {
        return a - b;
    }
}

// Класс для умножения
class Multiplication {
    public int multiply(int a, int b) {
        return a * b;
    }
}

// Класс для деления
class Division {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

// Интерфейс для калькулятора
interface Calculator {
    int calculate(int a, int b);
}

// Класс для приложения калькулятора
public class CalculatorApp {
    public static void main(String[] args) {
//        Calculator addition = new Addition();
//        Calculator subtraction = new Subtraction();
//        Calculator multiplication = new Multiplication();
//        Calculator division = new Division();
//
//        int result1 = addition.calculate(5, 3); // Результат сложения: 5 + 3 = 8
//        int result2 = subtraction.calculate(10, 4); // Результат вычитания: 10 - 4 = 6
//        int result3 = multiplication.calculate(2, 5); // Результат умножения: 2 * 5 = 10
//        int result4 = division.calculate(15, 3); // Результат деления: 15 / 3 = 5
   }
}

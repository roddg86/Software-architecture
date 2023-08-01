package example8;

/**
 * Пример контракта метода
 *
 * Класс, представляющий калькулятор.
 */
public class Calculator {

    /**
     * Выполняет деление двух чисел.
     *
     * @param dividend делимое (число, которое делим)
     * @param divisor  делитель (число, на которое делим)
     * @return результат деления в виде десятичной дроби типа double
     * @throws ArithmeticException если делитель равен нулю
     */
    public double divide(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return dividend / divisor;
    }
}

package example1;

// Представление
import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public double getFirstNumber() {
        System.out.print("Enter the first number: ");
        return scanner.nextDouble();
    }

    public double getSecondNumber() {
        System.out.print("Enter the second number: ");
        return scanner.nextDouble();
    }

    public char getOperator() {
        System.out.print("Enter the operator (+, -, *, /): ");
        return scanner.next().charAt(0);
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }
}

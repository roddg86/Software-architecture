//package goodexample;
//
//// Класс "UserInterface"
//public class UserInterface {
//    private example8.Calculator calculator;
//
//    public UserInterface() {
//        calculator = new example8.Calculator();
//    }
//
//    public void start() {
//        double num1 = getUserInput("Enter the first number: ");
//        double num2 = getUserInput("Enter the second number: ");
//        char operator = getOperator();
//
//        double result = performOperation(num1, num2, operator);
//
//        displayResult(result);
//    }
//
//    private double getUserInput(String message) {
//        // Здесь можно реализовать логику для получения числового ввода от пользователя
//    }
//
//    private char getOperator() {
//        // Здесь можно реализовать логику для получения оператора от пользователя
//    }
//
//    private double performOperation(double num1, double num2, char operator) {
//        // Здесь вызываются методы калькулятора для выполнения операций
//    }
//
//    private void displayResult(double result) {
//        // Здесь можно реализовать логику для отображения результата пользователю
//    }
//}
//
//// Класс "Main"
//public class Main {
//    public static void main(String[] args) {
//        UserInterface userInterface = new UserInterface();
//        userInterface.start();
//    }
//}

package example1;

// Контроллер
public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void calculate() {
        double num1 = view.getFirstNumber();
        double num2 = view.getSecondNumber();
        char operator = view.getOperator();

        try {
            switch (operator) {
                case '+':
                    model.add(num1, num2);
                    break;
                case '-':
                    model.subtract(num1, num2);
                    break;
                case '*':
                    model.multiply(num1, num2);
                    break;
                case '/':
                    model.divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operator.");
                    return;
            }

            double result = model.getResult();
            view.displayResult(result);
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
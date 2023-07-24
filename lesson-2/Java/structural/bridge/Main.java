package structural.bridge;

// Абстрактный класс для формы
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}

// Конкретная реализация формы - Круг
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Circle filled with color ");
        color.applyColor();
    }
}

// Конкретная реализация формы - Квадрат
class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Square filled with color ");
        color.applyColor();
    }
}

// Абстрактный класс для цвета
interface Color {
    void applyColor();
}

// Конкретная реализация цвета - Красный
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Red");
    }
}

// Конкретная реализация цвета - Зеленый
class GreenColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Green");
    }
}


public class Main {
    public static void main(String[] args) {
        // Создание объектов форм и цветов
        Shape redCircle = new Circle(new RedColor());
        Shape greenSquare = new Square(new GreenColor());

        // Применение цветов к формам
        redCircle.applyColor();   // Выведет: "Circle filled with color Red"
        greenSquare.applyColor(); // Выведет: "Square filled with color Green"
    }
}

#### Связанность и сочетаемость

Вам необходимо доработать код, добавив контракты к методам, 
документацию и обеспечив высокую связанность и низкую сочетаемость:

<details> 
  <summary>Кейс</summary>
// Класс для геометрических фигур
abstract class Shape {
    // Общие поля и методы для всех геометрических фигур
    abstract double getArea();
    abstract double getPerimeter();
}

// Класс для круга
class Circle extends Shape {
private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Класс для прямоугольника
class Rectangle extends Shape {
private double length;
private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getArea() {
        return length * width;
    }

    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }
}

// Класс для треугольника
class Triangle extends Shape {
private double side1;
private double side2;
private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }
}

// Главный класс приложения
public class GeometryApp {
public static void main(String[] args) {
// Пример использования конкретных классов геометрических фигур
Circle circle = new Circle(5.0);
System.out.println("Площадь круга: " + circle.getArea());
System.out.println("Периметр круга: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
    }
}
</details>

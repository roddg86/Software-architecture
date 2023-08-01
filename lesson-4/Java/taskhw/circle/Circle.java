package taskhw.circle;

import taskhw.shapefactory.Shape;

/**
 * Класс, представляющий круг.
 * Реализует интерфейс Shape.
 */
public class Circle implements Shape {
    private double radius;

    /**
     * Конструктор класса Circle.
     *
     * @param radius Радиус круга.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

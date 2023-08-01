package taskhw.rectangle;

import taskhw.shapefactory.Shape;

/**
 * Класс, представляющий прямоугольник.
 * Реализует интерфейс Shape.
 */
public class Rectangle implements Shape {
    private double length;
    private double width;

    /**
     * Конструктор для создания прямоугольника.
     *
     * @param length Длина прямоугольника.
     * @param width  Ширина прямоугольника.
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Получить площадь прямоугольника.
     *
     * @return Площадь прямоугольника.
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * Получить периметр прямоугольника.
     *
     * @return Периметр прямоугольника.
     */
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
}

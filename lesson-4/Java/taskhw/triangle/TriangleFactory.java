package taskhw.triangle;

import taskhw.shapefactory.Shape;
import taskhw.shapefactory.ShapeFactory;

/**
 * Этот класс представляет фабрику для создания треугольников.
 * Он реализует интерфейс ShapeFactory.
 */
public class TriangleFactory implements ShapeFactory {
    private double side1;
    private double side2;
    private double side3;

    /**
     * Конструктор для создания объекта фабрики треугольников.
     *
     * @param side1 Длина первой стороны треугольника.
     * @param side2 Длина второй стороны треугольника.
     * @param side3 Длина третьей стороны треугольника.
     */
    public TriangleFactory(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Метод для создания объекта треугольника.
     *
     * @return Объект треугольника.
     */
    @Override
    public Shape createShape() {
        return new Triangle(side1, side2, side3);
    }
}

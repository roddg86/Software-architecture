package taskhw.triangle;

import taskhw.shapefactory.Shape;

/**
 * Класс, представляющий треугольник.
 * Реализует интерфейс Shape.
 */
class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;

    /**
     * Конструктор для создания объекта треугольника.
     *
     * @param side1 Длина первой стороны треугольника.
     * @param side2 Длина второй стороны треугольника.
     * @param side3 Длина третьей стороны треугольника.
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Метод для вычисления площади треугольника.
     *
     * @return Площадь треугольника.
     */
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Метод для вычисления периметра треугольника.
     *
     * @return Периметр треугольника.
     */
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

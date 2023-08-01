package taskhw.rectangle;

import taskhw.shapefactory.Shape;
import taskhw.shapefactory.ShapeFactory;

// Фабрика для создания прямоугольников
public class RectangleFactory implements ShapeFactory {
    private double length;
    private double width;

    /**
     * Конструктор для создания фабрики прямоугольников.
     *
     * @param length Длина прямоугольников, создаваемых фабрикой.
     * @param width  Ширина прямоугольников, создаваемых фабрикой.
     */
    public RectangleFactory(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Создать прямоугольник.
     *
     * @return Созданный прямоугольник.
     */
    @Override
    public Shape createShape() {
        return new Rectangle(length, width);
    }
}

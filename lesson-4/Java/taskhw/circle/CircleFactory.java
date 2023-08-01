package taskhw.circle;

import taskhw.shapefactory.Shape;
import taskhw.shapefactory.ShapeFactory;

// Фабрика для создания кругов
public class CircleFactory implements ShapeFactory {
    private double radius;

    /**
     * Конструктор класса CircleFactory.
     *
     * @param radius Радиус для создаваемых кругов.
     */
    public CircleFactory(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape createShape() {
        return new Circle(radius);
    }
}

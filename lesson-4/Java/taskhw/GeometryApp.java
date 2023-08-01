package taskhw;

import taskhw.circle.CircleFactory;
import taskhw.rectangle.RectangleFactory;
import taskhw.shapefactory.Shape;
import taskhw.shapefactory.ShapeFactory;
import taskhw.triangle.TriangleFactory;

// Главный класс приложения
public class GeometryApp {
    public static void main(String[] args) {
        // Создаем фабрику кругов с радиусом 5.0
        ShapeFactory circleFactory = new CircleFactory(5.0);
        // Создаем круг с помощью фабрики кругов
        Shape circle = circleFactory.createShape();
        // Выводим площадь круга
        System.out.println("Площадь круга: " + circle.getArea());
        // Выводим периметр круга
        System.out.println("Периметр круга: " + circle.getPerimeter());

        // Создаем фабрику прямоугольников с шириной 4.0 и высотой 6.0
        ShapeFactory rectangleFactory = new RectangleFactory(4.0, 6.0);
        // Создаем прямоугольник с помощью фабрики прямоугольников
        Shape rectangle = rectangleFactory.createShape();
        // Выводим площадь прямоугольника
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        // Выводим периметр прямоугольника
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());

        // Создаем фабрику треугольников с длинами сторон 3.0, 4.0 и 5.0
        ShapeFactory triangleFactory = new TriangleFactory(3.0, 4.0, 5.0);
        // Создаем треугольник с помощью фабрики треугольников
        Shape triangle = triangleFactory.createShape();
        // Выводим площадь треугольника
        System.out.println("Площадь треугольника: " + triangle.getArea());
        // Выводим периметр треугольника
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
    }

}

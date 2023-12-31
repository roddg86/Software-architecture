package taskhw.shapefactory;

/**
 * Интерфейс для геометрических фигур
 * 
 * Этот интерфейс используется в качестве контракта для реализации различных
 * геометрических фигур.
 * Каждая фигура, реализующая этот интерфейс, должна предоставить свою
 * собственную реализацию этих методов.
 */
public interface Shape {
    /**
     * Возвращает площадь фигуры.
     *
     * @return площадь фигуры
     */
    double getArea();

    /**
     * Возвращает периметр фигуры.
     *
     * @return периметр фигуры
     */
    double getPerimeter();
}

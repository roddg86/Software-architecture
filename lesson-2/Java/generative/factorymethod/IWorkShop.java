package generative.factorymethod;

/**
 * Общий интерфейс для создания объектов в супер классе.
 *
 * Интерфейс представляет собой абстрактный цех
 * производящий автомобили
 *
 * метод create возвращает абстрактный автомобиль
 */
public interface IWorkShop {
    IProduction create();
}

package generative.factorymethod;

/**
 * Интерфейс представляет цех по производству легковых автомобилей
 *
 * метод create возвращает экземпляр легкового автомобиля
 */
public class CarWorkShop implements IWorkShop{
    @Override
    public IProduction create() {
        return new Car();
    }
}

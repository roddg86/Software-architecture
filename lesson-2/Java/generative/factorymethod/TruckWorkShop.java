package generative.factorymethod;

/**
 * Класс представляет абстрактный цех по производству
 * грузовых автомобилей
 *
 * метод create возвращает экземпляр грузового автомобиля
 */
public class TruckWorkShop implements IWorkShop{
    @Override
    public IProduction create() {
        return new Truck();
    }
}

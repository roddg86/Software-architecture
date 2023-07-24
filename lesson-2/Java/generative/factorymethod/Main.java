package generative.factorymethod;

public class Main {
    public static void main(String[] args) {
        // Экземпляр цеха по производству легковых автомобилей
        IWorkShop creator =  new CarWorkShop();

        // Результат выполнения метода create создаст легковой автомобиль
        IProduction car = creator.create();

        // Переквалифицируем цех на производство грузовых автомобилей
        creator = new TruckWorkShop();

        // Результат выполнения метода create создаст грузовой автомобиль
        IProduction truck = creator.create();

        // Вызовем метод release выполняющий выпуск автомобилей
        car.release();
        truck.release();
    }
}

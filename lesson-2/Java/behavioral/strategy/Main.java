package behavioral.strategy;

/**
 * Стратегия — это поведенческий паттерн проектирования, который определяет
 * семейство похожих алгоритмов и помещает каждый из них в собственный
 * класс, после чего алгоритмы взаимозаменяются прямо во время исполнения
 * программы.
 */

// Определяем интерфейс для различных типов ридеров
interface Reader {
    void parse(String text);
}

// Класс ResourceReader, использующий паттерн Стратегия
class ResourceReader {
    private Reader reader;

    // Конструктор для установки начальной стратегии
    public ResourceReader(Reader reader) {
        this.reader = reader;
    }

    // Метод для установки стратегии во время выполнения
    public void setStrategy(Reader reader) {
        this.reader = reader;
    }

    // Метод для чтения ресурса с использованием текущей стратегии
    public void read(String url) {
        reader.parse(url);
    }
}

// Реализация интерфейса Reader для чтения новостных сайтов
class NewsSiteReader implements Reader {
    @Override
    public void parse(String url) {
        System.out.println("Парсинг новостей с сайта: " + url);
    }
}

// Реализация интерфейса Reader для чтения социальных сетей
class SocialNetworkReader implements Reader {
    @Override
    public void parse(String url) {
        System.out.println("Парсинг новостей из социальной сети: " + url);
    }
}

// Реализация интерфейса Reader для чтения из Telegram
class TelegramReader implements Reader {
    @Override
    public void parse(String url) {
        System.out.println("Парсинг новостей в Telegram: " + url);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объект ResourceReader с стратегией NewsSiteReader
        ResourceReader reader = new ResourceReader(new NewsSiteReader());

        // Читаем содержимое с указанного URL-адреса с использованием текущей стратегии
        String url = "https://news.yandex.ru/";
        reader.read(url);

        // Переключаем стратегию на SocialNetworkReader
        reader.setStrategy(new SocialNetworkReader());

        // Читаем содержимое с указанного URL-адреса с использованием новой стратегии
        url = "https://www.facebook.com/";
        reader.read(url);

        // Переключаем стратегию на TelegramReader
        reader.setStrategy(new TelegramReader());

        // Читаем содержимое с указанного URL-адреса с использованием новой стратегии
        url = "@dostavka_news";
        reader.read(url);
    }
}

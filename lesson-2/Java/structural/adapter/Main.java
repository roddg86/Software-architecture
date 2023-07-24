package structural.adapter;

// Устаревший интерфейс
interface OldSystem {
    void request();
}

// Класс OldSystem имеет устаревший интерфейс
class LegacySystem implements OldSystem {
    @Override
    public void request() {
        System.out.println("Вызов устаревшего метода OldSystem.request()");
    }
}
// Новый интерфейс
interface NewSystem {
    void specificRequest();
}

// Класс NewSystem ожидает новый интерфейс
class ModernSystem implements NewSystem {
    @Override
    public void specificRequest() {
        System.out.println("Вызов нового метода ModernSystem.specificRequest()");
    }
}
// Адаптер, который преобразует OldSystem к NewSystem
class Adapter implements NewSystem {
    private OldSystem oldSystem;

    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void specificRequest() {
        oldSystem.request();
    }
}
public class Main {
    public static void main(String[] args) {
        OldSystem oldSystem = new LegacySystem();
        NewSystem newSystem = new ModernSystem();

        // Используем OldSystem через адаптер в новой системе
        NewSystem adapterSystem = new Adapter(oldSystem);
        newSystem.specificRequest();
        adapterSystem.specificRequest();
    }
}

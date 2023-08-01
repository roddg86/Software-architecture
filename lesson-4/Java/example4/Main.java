package example4;

// Суперкласс
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Подкласс, который оверрайдит метод makeSound()
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound(); // Выведет: "Animal makes a sound"

        Dog dog = new Dog();
        dog.makeSound(); // Выведет: "Dog barks"
    }
}

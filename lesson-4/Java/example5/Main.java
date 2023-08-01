package example5;

// Родительский класс, представляющий животное
class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры и сеттеры для полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void makeSound() {
        // Реализация будет в классах-потомках
    }
}

// Класс представляющий собаку
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void bark() {
        System.out.println(getName() + " is barking.");
    }
}

// Класс представляющий кошку
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.println(getName() + " is meowing.");
    }
}

// Класс представляющий птицу
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    public void chirp() {
        System.out.println(getName() + " is chirping.");
    }
}

/*class AnimalApp {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3);
        Cat cat = new Cat("Whiskers", 2);
        Bird bird = new Bird("Tweety", 1);

        dog.bark();
        cat.meow();
        bird.chirp();
    }
}*/

// низкая сочетаемость(хороший пример)
class AnimalApp {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}

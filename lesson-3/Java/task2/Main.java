package task2;

/**
 * Сделать рефакторинг кода на основании принципа открытости закрытости
 *
 * public class Greeting {
 *     private String type;
 *
 *     public Greeting(String type) {
 *         this.type = type;
 *     }
 *
 *     public void greet() {
 *         if ("formal".equals(type)) {
 *             System.out.println("Добро пожаловать, уважаемый гость!");
 *         } else if ("informal".equals(type)) {
 *             System.out.println("Привет, друг!");
 *         }
 *     }
 * }
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         Greeting greeting = new Greeting("informal");
 *         greeting.greet();
 *     }
 * }
 */
public class Main {
    public static void main(String[] args) {
         Igreet informalGreet = new InformalGreet();
         Igreet formalGreet = new FormalGreet();
         informalGreet.greet();
         formalGreet.greet();

     }
}

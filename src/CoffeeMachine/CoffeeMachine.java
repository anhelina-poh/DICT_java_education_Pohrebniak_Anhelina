package CoffeeMachine;

import java.util.Scanner;

@SuppressWarnings("all")
public class CoffeeMachine {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker maker = new CoffeeMaker();

        System.out.println("Write how many ml of water the coffee machine has:");
        System.out.print("> ");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        System.out.print("> ");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        System.out.print("> ");
        int beans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int neededCups = scanner.nextInt();

        maker.checkCapability(water, milk, beans, neededCups);

        scanner.close();
    }
}
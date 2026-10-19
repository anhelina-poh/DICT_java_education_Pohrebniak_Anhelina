package CoffeeMachine;

import java.util.Scanner;

@SuppressWarnings("all")
public class CoffeeMachine {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker maker = new CoffeeMaker();

        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int cups = scanner.nextInt();

        maker.calculateIngredients(cups);

        scanner.close();
    }
}
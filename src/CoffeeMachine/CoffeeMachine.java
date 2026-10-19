package CoffeeMachine;

import java.util.Scanner;

@SuppressWarnings("all")
public class CoffeeMachine {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker maker = new CoffeeMaker();

        maker.printStatus();
        System.out.println("Write action (buy, fill, take):");
        System.out.print("> ");
        String action = scanner.next();

        switch (action) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                System.out.print("> ");
                int type = scanner.nextInt();
                maker.buyCoffee(type);
            }
            case "fill" -> {
                System.out.println("Write how many ml of water you want to add:");
                System.out.print("> ");
                int w = scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                System.out.print("> ");
                int m = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                System.out.print("> ");
                int b = scanner.nextInt();
                System.out.println("Write how many disposable coffee cups you want to add:");
                System.out.print("> ");
                int c = scanner.nextInt();
                maker.addSupplies(w, m, b, c);
            }
            case "take" -> maker.takeMoney();
        }

        maker.printStatus();
        scanner.close();
    }
}
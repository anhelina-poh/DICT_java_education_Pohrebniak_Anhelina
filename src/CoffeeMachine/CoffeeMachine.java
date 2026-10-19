package CoffeeMachine;

import java.util.Scanner;

@SuppressWarnings("all")
public class CoffeeMachine {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker maker = new CoffeeMaker();

        maker.promptAction();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();

            if ("exit".equals(input)) {
                break;
            }

            maker.processInput(input);
        }

        scanner.close();
    }
}
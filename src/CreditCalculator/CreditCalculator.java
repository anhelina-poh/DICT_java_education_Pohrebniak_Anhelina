package CreditCalculator;

import java.util.Locale;
import java.util.Scanner;

@SuppressWarnings("all")
public class CreditCalculator {
    static void main() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        CalculatorLogic logic = new CalculatorLogic();
        logic.calculateSimpleLoan(scanner);
        scanner.close();
    }
}
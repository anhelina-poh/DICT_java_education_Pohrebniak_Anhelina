package CreditCalculator;

import java.util.Scanner;

@SuppressWarnings("all")
public class CalculatorLogic {
    public void calculateSimpleLoan(Scanner scanner) {
        System.out.println("Enter the loan principal:");
        System.out.print("> ");
        double principal = scanner.nextDouble();

        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" - for number of monthly payments,");
        System.out.println("type \"p\" - for the monthly payment:");
        System.out.print("> ");
        String choice = scanner.next();

        if ("m".equals(choice)) {
            System.out.println("Enter the monthly payment:");
            System.out.print("> ");
            double payment = scanner.nextDouble();
            int months = (int) Math.ceil(principal / payment);
            if (months == 1) {
                System.out.println("It will take 1 month to repay the loan");
            } else {
                System.out.println("It will take " + months + " months to repay the loan");
            }
        } else if ("p".equals(choice)) {
            System.out.println("Enter the number of months:");
            System.out.print("> ");
            int months = scanner.nextInt();
            int payment = (int) Math.ceil(principal / months);
            int lastPayment = (int) (principal - (months - 1) * payment);

            if (lastPayment == payment) {
                System.out.println("Your monthly payment = " + payment);
            } else {
                System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment + ".");
            }
        }
    }
}
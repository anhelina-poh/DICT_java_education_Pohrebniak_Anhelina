package CreditCalculator;

import java.util.Scanner;

@SuppressWarnings("all")
public class CalculatorLogic {
    public void calculateAnnuityInteractive(Scanner scanner) {
        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        System.out.print("> ");
        String choice = scanner.next();

        switch (choice) {
            case "n" -> {
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                double principal = scanner.nextDouble();
                System.out.println("Enter the monthly payment:");
                System.out.print("> ");
                double payment = scanner.nextDouble();
                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                double interest = scanner.nextDouble();

                double i = interest / (12 * 100);
                double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
                int totalMonths = (int) Math.ceil(n);
                displayPeriod(totalMonths);
            }
            case "a" -> {
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                double principal = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                System.out.print("> ");
                int periods = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                double interest = scanner.nextDouble();

                double i = interest / (12 * 100);
                double a = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
                int payment = (int) Math.ceil(a);
                System.out.println("Your monthly payment = " + payment + "!");
            }
            case "p" -> {
                System.out.println("Enter the annuity payment:");
                System.out.print("> ");
                double payment = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                System.out.print("> ");
                int periods = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                double interest = scanner.nextDouble();

                double i = interest / (12 * 100);
                double p = payment / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));
                System.out.println("Your loan principal = " + Math.round(p) + "!");
            }
        }
    }

    private void displayPeriod(int totalMonths) {
        int years = totalMonths / 12;
        int months = totalMonths % 12;

        if (years == 0) {
            System.out.println("It will take " + months + (months == 1 ? " month" : " months") + " to repay this loan!");
        } else if (months == 0) {
            System.out.println("It will take " + years + (years == 1 ? " year" : " years") + " to repay this loan!");
        } else {
            System.out.println("It will take " + years + (years == 1 ? " year" : " years") +
                    " and " + months + (months == 1 ? " month" : " months") + " to repay this loan!");
        }
    }
}
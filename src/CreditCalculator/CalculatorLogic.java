package CreditCalculator;

@SuppressWarnings("all")
public class CalculatorLogic {

    public void dataAnalyze(String type, String principalStr, String periodsStr,
                            String interestStr, String paymentStr) {
        if (!validateParameters(type, principalStr, periodsStr, interestStr, paymentStr)) {
            System.out.println("Incorrect parameters");
            return;
        }

        try {
            double principal = principalStr != null ? Double.parseDouble(principalStr.replace(',', '.')) : 0;
            int periods = periodsStr != null ? Integer.parseInt(periodsStr) : 0;
            double annualInterest = interestStr != null ? Double.parseDouble(interestStr.replace(',', '.')) : 0;
            double payment = paymentStr != null ? Double.parseDouble(paymentStr.replace(',', '.')) : 0;

            if (principal < 0 || periods < 0 || annualInterest < 0 || payment < 0) {
                System.out.println("Incorrect parameters");
                return;
            }

            double monthInterest = annualInterest / (12 * 100);

            switch (type) {
                case "diff" -> calculateDiff(principal, periods, monthInterest);
                case "annuity" -> calculateAnnuity(principal, periods, monthInterest, payment);
                default -> System.out.println("Incorrect parameters");
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect parameters");
        }
    }

    private boolean validateParameters(String type, String principalStr, String periodsStr,
                                       String interestStr, String paymentStr) {
        if (type == null || (!type.equals("diff") && !type.equals("annuity"))) {
            return false;
        }
        if (interestStr == null) {
            return false;
        }

        if ("diff".equals(type)) {
            if (paymentStr != null) {
                return false;
            }
            return principalStr != null && periodsStr != null;
        }

        if ("annuity".equals(type)) {
            int provided = 0;
            if (principalStr != null) provided++;
            if (periodsStr != null) provided++;
            if (paymentStr != null) provided++;
            return provided == 2;
        }

        return false;
    }

    private void calculateDiff(double principal, int periods, double monthlyInterest) {
        double totalPaid = 0;
        double basePay = principal / periods;

        for (int month = 1; month <= periods; month++) {
            double diffPay = basePay + monthlyInterest * (principal - basePay * (month - 1));
            diffPay = Math.ceil(diffPay);
            totalPaid += diffPay;
            System.out.println("Month " + month + ": payment is " + (long) diffPay);
        }

        long overpay = Math.round(totalPaid - principal);
        System.out.println("Overpayment = " + overpay);
    }

    private void calculateAnnuity(double principal, int periods, double monthlyInterest, double payment) {
        if (principal == 0) {
            double factor = (monthlyInterest * Math.pow(1 + monthlyInterest, periods)) /
                    (Math.pow(1 + monthlyInterest, periods) - 1);
            double loanPrincipal = payment / factor;
            long roundedPrincipal = Math.round(loanPrincipal);
            System.out.println("Your loan principal = " + roundedPrincipal + "!");
            long overpayment = Math.round(payment * periods - loanPrincipal);
            System.out.println("Overpayment = " + overpayment);
        } else if (periods == 0) {
            double n = Math.log(payment / (payment - monthlyInterest * principal)) /
                    Math.log(1 + monthlyInterest);
            int months = (int) Math.ceil(n);
            displayPeriod(months);
            long overpayment = Math.round(payment * months - principal);
            System.out.println("Overpayment = " + overpayment);
        } else if (payment == 0) {
            double factor = (monthlyInterest * Math.pow(1 + monthlyInterest, periods)) /
                    (Math.pow(1 + monthlyInterest, periods) - 1);
            long annuityPay = (long) Math.ceil(principal * factor);
            System.out.println("Your annuity payment = " + annuityPay + "!");
            long overpayment = annuityPay * periods - (long) principal;
            System.out.println("Overpayment = " + overpayment);
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
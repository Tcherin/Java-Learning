import com.sun.org.apache.xpath.internal.operations.Number;

import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.currency = NumberFormat.getCurrencyInstance();
        this.calculator = calculator;
    }

    void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage Payments: " + mortgageFormatted);
    }

    void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
        System.out.println(currency.format(balance));
        }
}

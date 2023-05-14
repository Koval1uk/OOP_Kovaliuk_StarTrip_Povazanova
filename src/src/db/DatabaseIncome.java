package src.db;

import src.mode.PaymentStat;

import java.util.ArrayList;
import java.util.Random;

public class DatabaseIncome {
    public static ArrayList<PaymentStat> paymentStatTable = new ArrayList<>();


    static {
        paymentStatTable.add(
                new PaymentStat("JANUARY", 75000.00, 90000.00, 60000.00, 5000.00, 2000.00)
        );
        paymentStatTable.add(
                new PaymentStat("FEBRUARY", 80000.00, 70000.00, 60000.00, 4000.00, 1500.00)
        );
        paymentStatTable.add(
                new PaymentStat("MARCH", 90000.00, 85000.00, 60000.00, 5500.00, 3000.00)
        );
        paymentStatTable.add(
                new PaymentStat("APRIL", 70000.00, 95000.00, 60000.00, 6000.00, 2500.00)
        );
        paymentStatTable.add(
                new PaymentStat("MAY", 60000.00, 80000.00, 60000.00, 3500.00, 1000.00)
        );
        paymentStatTable.add(
                new PaymentStat("JUNE", 85000.00, 90000.00, 60000.00, 4500.00, 1800.00)
        );
        paymentStatTable.add(
                new PaymentStat("JULY", 80000.00, 85000.00, 60000.00, 5000.00, 2200.00)
        );
        paymentStatTable.add(
                new PaymentStat("AUGUST", 90000.00, 70000.00, 60000.00, 4000.00, 1700.00)
        );
        paymentStatTable.add(
                new PaymentStat("SEPTEMBER", 95000.00, 95000.00, 60000.00, 5500.00, 3200.00)
        );
        paymentStatTable.add(
                new PaymentStat("OCTOBER", 75000.00, 80000.00, 60000.00, 6000.00, 2700.00)
        );
        paymentStatTable.add(
                new PaymentStat("NOVEMBER", 70000.00, 90000.00, 60000.00, 3500.00, 1200.00)
        );
        paymentStatTable.add(
                new PaymentStat("DECEMBER", 85000.00, 85000.00, 60000.00, 4500.00, 2000.00)
        );
    }

    static String generateRandomMonth() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        Random rand = new Random();
        return months[rand.nextInt(months.length)];
    }

    static double generateRandomValue() {
        Random rand = new Random();
        return rand.nextDouble() * 50000 + 50000;
    }

    static void printPaymentStatTable() {
        for (PaymentStat paymentStat : paymentStatTable) {
            System.out.println("Month: " + paymentStat.getMonth());
            System.out.println("Income: $" + paymentStat.getIncome());
            System.out.println("Expenses: $" + paymentStat.getExpenses());
            System.out.println("Profit: $" + paymentStat.getProfit());
            System.out.println("Tax Paid: $" + paymentStat.getTaxPaid());
            System.out.println("Net Profit: $" + paymentStat.getNetProfit());
            System.out.println("--------------------------");
        }
    }
}


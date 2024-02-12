package javaX;

import java.util.Scanner;

public class Tracker {
    double startingShare;
    int day = 1;
    double[] weekly = new double[7];
    double sum = 0;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting share: ");
        startingShare = scanner.nextDouble();
        while (day <= 7) {
            System.out.printf("Enter day %d share: \n", day);
            weekly[day-1] = scanner.nextDouble();
            day++;
        }

        for (int i = 0; i < weekly.length; i++) {
            double profit = weekly[i] - startingShare;
            sum += profit;
            if (profit > 0) {
                System.out.printf("Profit for the day %d: %.2f\n", i+1, profit);
            } else if (profit == 0) {
                System.out.printf("Nothing earned for the day %d\n", i+1);
            } else {
                System.out.printf("Loss for the day %d: %.2f\n", i+1, -profit);
            }


        }

        System.out.printf("Total profit for the week: %.2f\n", sum);

        scanner.close();
    }
}

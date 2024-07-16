package javaX;

import java.util.LinkedList;
import java.util.UUID;

public class Account {
    String customerName;
    String customerId;
    int balance = 0;
    LinkedList<Integer> transactionHistory = new LinkedList<>();
    int historySize = 10;

    public Account(String customerName) {
        this.customerName = customerName;
        this.customerId = UUID.randomUUID().toString();
        System.out.printf("Created account for %s (id %s)\n", customerName, customerId);
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        this.balance += amount;
        System.out.printf("Deposit successful. New balance is %d\n", this.balance);

        recordTransaction(amount);
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Withdraw amount must be grater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds, cannot withdraw.");
            return;
        }

        this.balance -= amount;
        System.out.printf("Withdrawal successful. New balance is %d\n", this.balance);

        recordTransaction(-amount);
    }

    public void getTransactionHistory() {
        System.out.printf("Transaction history (for last %d operations)\n", this.historySize);
        for (Integer value : transactionHistory) {
            if (value > 0) {
                System.out.println("Deposit " + value);
            } else if (value < 0) {
                System.out.println("Withdrawal " + value);
            }
        }
        if (transactionHistory.isEmpty()) {
            System.out.println("no recent transactions.");
        }
    }

    public void calculateInterest(int years) {
        float interestRate = 0.184f;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.printf("The current interest rate is %s%%\n", 100 * interestRate);
        System.out.printf("After %d years your balance will be: %s\n", years, Math.round(newBalance));
    }

    private void recordTransaction(int amount) {
        this.transactionHistory.add(amount);
        // Remove the oldest record if history is full
        if (this.transactionHistory.size() > this.historySize) {
            this.transactionHistory.pop();
        }
    }
}

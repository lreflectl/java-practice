package javaX;

import java.util.Scanner;

public class Bank {
    Account account;
    Scanner scanner;

    public Bank() {
        scanner = new Scanner(System.in);
        System.out.println("Enter account name:");
        String customerName = scanner.nextLine();
        this.account = new Account(customerName);
    }

    public void enterMenu() {
        System.out.println("-------------------");
        System.out.printf("Welcome, %s!\n", account.customerName);
        System.out.println("Your ID is: " + account.customerId);
        System.out.println("-------------------");
        System.out.println("Select any Option To Proceed");
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Transactions History");
        System.out.println("E. Interest");
        System.out.println("F. Exit");

        char option;
        boolean exitFlag = false;

        while (!exitFlag) {
            System.out.println("Enter Your Choice:");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println("Account Balance = $" + account.balance);
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 'D':
                    account.getTransactionHistory();
                    break;
                case 'E':
                    System.out.println("Enter the years for which you wish to calculate interest:");
                    int years = scanner.nextInt();
                    account.calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("Thank you for banking with us!");
                    scanner.close();
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Error: Invalid option. Please enter A, B, C, D, or E to access services");
            }
        }
    }
}

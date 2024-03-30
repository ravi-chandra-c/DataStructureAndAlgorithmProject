package com.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Transfer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNumber = scanner.nextInt();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    bank.addAccount(accNumber, balance);
                    System.out.println("Account added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    double accBalance = bank.checkBalance(accNumber);
                    if (accBalance >= 0) {
                        System.out.println("Balance: $" + accBalance);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter from account number: ");
                    int fromAcc = scanner.nextInt();
                    System.out.print("Enter to account number: ");
                    int toAcc = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double amount = scanner.nextDouble();
                    boolean success = bank.transfer(fromAcc, toAcc, amount);
                    if (success) {
                        System.out.println("Transfer successful!");
                    } else {
                        System.out.println("Transfer failed! Either from account doesn't have sufficient balance or invalid account.");
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
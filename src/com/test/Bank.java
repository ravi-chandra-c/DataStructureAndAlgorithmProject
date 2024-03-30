package com.test;

class Bank {
    LinkedList accounts;

    public Bank() {
        this.accounts = new LinkedList();
    }

    public void addAccount(int accountNumber, double balance) {
        accounts.add(accountNumber, balance);
    }

    public double checkBalance(int accountNumber) {
        return accounts.getBalance(accountNumber);
    }

    public boolean transfer(int fromAccount, int toAccount, double amount) {
        double fromBalance = accounts.getBalance(fromAccount);
        double toBalance = accounts.getBalance(toAccount);
        
        if (fromBalance >= amount) {
            // Withdraw from 'fromAccount'
            Node fromNode = accounts.head;
            while (fromNode != null) {
                if (fromNode.accountNumber == fromAccount) {
                    fromNode.balance -= amount;
                    break;
                }
                fromNode = fromNode.next;
            }
            
            // Deposit to 'toAccount'
            Node toNode = accounts.head;
            while (toNode != null) {
                if (toNode.accountNumber == toAccount) {
                    toNode.balance += amount;
                    return true; // Transfer successful
                }
                toNode = toNode.next;
            }
        }
        
        return false; // Insufficient balance or invalid account
    }
}

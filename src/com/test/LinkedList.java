package com.test;

class LinkedList {
    Node head;

    public void add(int accountNumber, double balance) {
        Node newNode = new Node(accountNumber, balance);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public double getBalance(int accountNumber) {
        Node current = head;
        while (current != null) {
            if (current.accountNumber == accountNumber) {
                return current.balance;
            }
            current = current.next;
        }
        return -1; // Account not found
    }

    // Additional methods for removing nodes, etc. can be added here
    //To test git
}
package com.task2.multithreadedapp;

public class Customer extends Thread {
	
	private BankAccount account;
    private String name;
    private double amount;
    
    public Customer(BankAccount account, String name, double amount) {
        this.account = account;
        this.name = name;
        this.amount = amount;
    }
    
    public void run() {
        account.withdraw(name, amount);
    }

}

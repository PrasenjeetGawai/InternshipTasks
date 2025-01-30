package com.task2.multithreadedapp;

public class BankAccount {

	private double balance;

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	public synchronized void withdraw(String customer, double amount) {
		if (amount <= balance) {
			System.out.println(customer + " is withdrawing " + amount);
			balance -= amount;
			System.out.println("Remaining balance: " + balance);
		} else {
			System.out.println(customer + " attempted to withdraw " + amount + " but insufficient funds!");
		}
	}

}

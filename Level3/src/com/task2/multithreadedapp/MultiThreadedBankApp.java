package com.task2.multithreadedapp;

public class MultiThreadedBankApp {
	
	 public static void main(String[] args) {
	        BankAccount account = new BankAccount(1000);
	        
	        Customer customer1 = new Customer(account, "Rahul", 600);
	        Customer customer2 = new Customer(account, "Akash", 500);
	        Customer customer3 = new Customer(account, "Rama", 400);
	        
	        customer1.start();
	        customer2.start();
	        customer3.start();
	    }

}

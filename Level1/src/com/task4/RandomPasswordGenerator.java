package com.task4;

import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

	public static void passwordGenerator() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the desired length of the password: ");
		int length = sc.nextInt();

		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";
		String specialChars = "!@#$%^&*()_-+=<>?";

		String allChars = lowercase + uppercase + numbers + specialChars;

		Random random = new Random();

		String password = "";

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(allChars.length());
			password += allChars.charAt(randomIndex);
		}

		System.out.println("Generated Password: " + password);

	}

	public static void main(String[] args) {
		RandomPasswordGenerator.passwordGenerator();
	}

}

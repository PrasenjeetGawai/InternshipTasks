package com.task2;

import java.util.Scanner;

public class PasswordStrengthChecker {

	public static String checkPasswordStrength(String password) {
		if (password.length() < 6) {
			return "Weak";
		}

		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasDigit = false;
		boolean hasSpecialChar = false;

		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);

			if (Character.isUpperCase(ch)) {
				hasUpperCase = true;
			}
			if (Character.isLowerCase(ch)) {
				hasLowerCase = true;
			}
			if (Character.isDigit(ch)) {
				hasDigit = true;
			}
			if (!Character.isLetterOrDigit(ch)) {
				hasSpecialChar = true;
			}
		}

		if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
			return "Strong";
		} else if (hasUpperCase || hasLowerCase || hasDigit) {
			return "Medium";
		} else {
			return "Weak";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a password: ");
		String password = sc.nextLine();

		String strength = checkPasswordStrength(password);

		System.out.println("Password Strength: " + strength);
	}

}

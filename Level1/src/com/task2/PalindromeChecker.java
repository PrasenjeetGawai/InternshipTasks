package com.task2;

import java.util.Scanner;

public class PalindromeChecker {

	public void checkPalindrome() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a word or phrase: ");
		String input = sc.nextLine();

		input = input.replace(" ", "").toLowerCase();

		boolean isPalindrome = true;

		int left = 0;
		int right = input.length() - 1;

		while (left < right) {
			if (input.charAt(left) != input.charAt(right)) {
				isPalindrome = false;
				break;
			}
			left++;
			right--;

		}

		if (isPalindrome) {
			System.out.println("The word or phrase is a palindrome.");
		} else {
			System.out.println("The word or phrase is not a palindrome.");
		}

	}

	public static void main(String[] args) {
		PalindromeChecker p1 = new PalindromeChecker();
		p1.checkPalindrome();
	}

}

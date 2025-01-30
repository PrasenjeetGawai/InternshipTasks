package com.task3;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void calculator() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of grades: ");
		int numGrades = sc.nextInt();

		double total = 0;

		for (int i = 1; i <= numGrades; i++) {
			System.out.print("Enter grade " + i + ": ");
			double grade = sc.nextDouble();
			total += grade;
		}

		double average = total / numGrades;

		System.out.println("The average grade is: " + average);

	}

	public static void main(String[] args) {
		StudentGradeCalculator.calculator();
	}

}

package com.task1;

import java.util.Scanner;

public class TemperatureConverter {

	public static void converter() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the temperature: ");
		double temperature = sc.nextDouble();

		System.out.println("Enter the unit (C for Celsius, F for Fahrenheit): ");
		String unit = sc.next();

		if (unit.equalsIgnoreCase("C")) {

			double fahrenheit = (temperature * 9 / 5) + 32;
			System.out.println(temperature + " Celsius is " + fahrenheit + " Fahrenheit.");
		} else if (unit.equalsIgnoreCase("F")) {

			double celsius = (temperature - 32) * 5 / 9;
			System.out.println(temperature + " Fahrenheit is " + celsius + " Celsius.");
		} else {
			System.out.println("Invalid unit entered! Please enter 'C' or 'F'.");
		}

	}

	public static void main(String[] args) {
		TemperatureConverter.converter();
	}

}

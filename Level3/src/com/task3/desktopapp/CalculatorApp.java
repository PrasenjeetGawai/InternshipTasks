package com.task3.desktopapp;

import javax.swing.SwingUtilities;

public class CalculatorApp {
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
	}
}

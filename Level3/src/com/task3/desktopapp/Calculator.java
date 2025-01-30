package com.task3.desktopapp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
	
	 private JTextField textField;
	    private double num1, num2, result;
	    private char operator;

	    public Calculator() {
	        setTitle("Calculator");
	        setSize(300, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        textField = new JTextField();
	        textField.setFont(new Font("Arial", Font.BOLD, 24));
	        textField.setHorizontalAlignment(JTextField.RIGHT);
	        add(textField, BorderLayout.NORTH);

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(4, 4));

	        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};

	        for (String text : buttons) {
	            JButton button = new JButton(text);
	            button.setFont(new Font("Arial", Font.BOLD, 20));
	            button.addActionListener(this);
	            panel.add(button);
	        }

	        add(panel, BorderLayout.CENTER);
	    }

	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();
	        
	        if (command.matches("[0-9]")) {
	            textField.setText(textField.getText() + command);
	        } else if (command.equals("C")) {
	            textField.setText("");
	            num1 = num2 = result = 0;
	        } else if (command.equals("=")) {
	            if (!textField.getText().isEmpty()) {  
	                num2 = Double.parseDouble(textField.getText());
	                switch (operator) {
	                    case '+': result = num1 + num2; break;
	                    case '-': result = num1 - num2; break;
	                    case '*': result = num1 * num2; break;
	                    case '/': 
	                        if (num2 != 0) {
	                            result = num1 / num2;
	                        } else {
	                            textField.setText("Error");
	                            return;
	                        }
	                        break;
	                }
	                textField.setText(String.valueOf(result));
	            }
	        } else {
	            if (!textField.getText().isEmpty()) {  
	                num1 = Double.parseDouble(textField.getText());
	                operator = command.charAt(0);
	                textField.setText("");
	            }
	        }
	    }


}

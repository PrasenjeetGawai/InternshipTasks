package com.task4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CurrencyConverter {
    private JFrame frame;
    private JTextField amountField;
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JLabel resultLabel;
    private JButton convertButton;

    public CurrencyConverter() {
        frame = new JFrame("Currency Converter");
        frame.setSize(400, 250);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLayout(new FlowLayout());

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        
        JLabel fromLabel = new JLabel("From:");
        fromCurrency = new JComboBox<>(new String[]{"USD", "EUR", "INR", "GBP", "JPY"});
        
        JLabel toLabel = new JLabel("To:");
        toCurrency = new JComboBox<>(new String[]{"USD", "EUR", "INR", "GBP", "JPY"});
        
        convertButton = new JButton("Convert");
        
        // Action for the button
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();  
            }
        });

        resultLabel = new JLabel("Converted Amount: ");
        
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(fromLabel);
        frame.add(fromCurrency);
        frame.add(toLabel);
        frame.add(toCurrency);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);  
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());

            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double rate = getExchangeRate(from, to);

            double convertedAmount = amount * rate;

            resultLabel.setText("Converted Amount: " + convertedAmount);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double getExchangeRate(String from, String to) {
        if (from.equals("USD") && to.equals("EUR")) return 0.85;
        if (from.equals("USD") && to.equals("INR")) return 74.5;
        if (from.equals("USD") && to.equals("GBP")) return 0.75;
        if (from.equals("USD") && to.equals("JPY")) return 110.5;
        if (from.equals("EUR") && to.equals("USD")) return 1.18;
        if (from.equals("INR") && to.equals("USD")) return 0.013;
        return 1.0;
    }
}

package com.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileEncryptDecrypt {

    public static void encryptFile(String fileName, int shift) {
        try {
            if (!Files.exists(Paths.get(fileName))) {
                System.out.println("The file does not exist: " + fileName);
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            String encryptedContent = caesarCipher(content.toString(), shift);

            String fileNameWithoutPath = Paths.get(fileName).getFileName().toString();
            String encryptedFileName = "encrypted_" + fileNameWithoutPath;

            BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFileName));
            writer.write(encryptedContent);
            writer.close();

            System.out.println("File encrypted successfully! Saved to " + encryptedFileName);

        } catch (IOException e) {
            System.out.println("Error with file reading or writing: " + e.getMessage());
        }
    }

    public static void decryptFile(String fileName, int shift) {
        try {
            if (!Files.exists(Paths.get(fileName))) {
                System.out.println("The file does not exist: " + fileName);
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            String decryptedContent = caesarCipher(content.toString(), -shift);

            String fileNameWithoutPath = Paths.get(fileName).getFileName().toString();
            String decryptedFileName = "decrypted_" + fileNameWithoutPath;

            BufferedWriter writer = new BufferedWriter(new FileWriter(decryptedFileName));
            writer.write(decryptedContent);
            writer.close();

            System.out.println("File decrypted successfully! Saved to " + decryptedFileName);

        } catch (IOException e) {
            System.out.println("Error with file reading or writing: " + e.getMessage());
        }
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                char base = (Character.isLowerCase(c)) ? 'a' : 'A';
                c = (char) ((c - base + shift + 26) % 26 + base);
            }

            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to encrypt or decrypt the file? (enter 'encrypt' or 'decrypt'): ");
        String action = sc.nextLine();

        System.out.print("Enter the file name or path: ");
        String fileName = sc.nextLine().trim(); 

        System.out.print("Enter the shift value (a number): ");
        int shift = sc.nextInt();
        sc.nextLine();  

        if (action.equals("encrypt")) {
            encryptFile(fileName, shift);
        } else if (action.equals("decrypt")) {
            decryptFile(fileName, shift);
        } else {
            System.out.println("Invalid action entered. Please enter 'encrypt' or 'decrypt'.");
        }
    }
}

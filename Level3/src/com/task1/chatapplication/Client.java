package com.task1.chatapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	
	Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	
	
	public Client() {
		
		try {
			System.out.println("Sending request to server....");
			socket = new Socket("localhost",7777);
			System.out.println("connection done.!");
			

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream());

			startReading();
			startWriting();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void startReading() {

		Runnable r1 = () -> {

			System.out.println("Start Reading....");

			try {
				while (true) {
					String serverMsg = bufferedReader.readLine();

					if (serverMsg.equals("exit")) {
						System.out.println("Client exit from chat...");
						break;
					}

					System.out.println("Server : " + serverMsg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		};

		new Thread(r1).start();
	}

	public void startWriting() {
		
		Runnable r2 = () -> {

			System.out.println("Start writing....");

			try {
				while (true) {
					
					BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
					String content = br1.readLine();
					printWriter.println(content);
					printWriter.flush();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		};

		new Thread(r2).start();
	}
	
	public static void main(String[] args) {
		System.out.println("This is Client...");
		new Client();
	}
	 

}

package com.task1.chatapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;

	public Server() {

		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("Server is ready to accept connection....");
			System.out.println("waiting.....");
			socket = serverSocket.accept();

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
					String clientMsg = bufferedReader.readLine();

					if (clientMsg.equals("exit")) {
						System.out.println("Client exit from chat...");
						break;
					}

					System.out.println("Client : " + clientMsg);
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
		System.out.println("This is Server... going to start..");
		new Server();
	}

}

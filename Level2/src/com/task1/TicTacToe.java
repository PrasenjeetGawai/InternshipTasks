package com.task1;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		char currentPlayer = 'X';

		boolean gameOver = false;
		while (!gameOver) {
			printBoard(board);
			System.out.println("Player " + currentPlayer + ", it's your turn.");
			System.out.print("Enter row (0, 1, or 2): ");
			int row = sc.nextInt();
			System.out.print("Enter column (0, 1, or 2): ");
			int col = sc.nextInt();

			if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
				board[row][col] = currentPlayer;

				if (checkWinner(board, currentPlayer)) {
					printBoard(board);
					System.out.println("Player " + currentPlayer + " wins!");
					gameOver = true;
				} else {
					currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
				}
			} else {
				System.out.println("Invalid move. Try again.");
			}

			if (isBoardFull(board)) {
				printBoard(board);
				System.out.println("It's a draw!");
				gameOver = true;
			}
		}

	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
				if (j < 2)
					System.out.print(" | ");
			}
			System.out.println();
			if (i < 2)
				System.out.println("---------");
		}
	}

	public static boolean checkWinner(char[][] board, char player) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}

	public static boolean isBoardFull(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}

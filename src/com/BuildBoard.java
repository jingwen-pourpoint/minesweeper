package com;

import java.util.Random;
import java.util.Scanner;

public class BuildBoard {
    private char[][] board;
    private int field = 9;
    private char safe = '.';
    private char mine = 'X';

    void setSafe() {
        board = new char[field][field];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = safe;
            }
        }
    }

    void setMines(Scanner scanner) {
        int mines = scanner.nextInt();
        Random random = new Random();
        int x;
        int y;
        for (int i = 0; i < mines; i++) {
            do {
                x = random.nextInt(field);
                y = random.nextInt(field);
            } while (board[x][y] == mine);
            board[x][y] = mine;
        }
    }


    void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}

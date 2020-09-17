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

    void setNumbers() {
        for (int i = 0; i < field; i++) {
            for (int j = 0; j < field; j++) {
                if (board[i][j] != mine) {
                    int numberMines = checkMines(i, j);
                    if (numberMines != 0) {
                        board[i][j] = Character.forDigit(numberMines, 10);
                    }
                }
            }
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

    int checkMines(int row, int column) {
        int numberMines = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if (i == -1 || i == field) {
                continue;
            }
            for (int j = column - 1; j <= column + 1; j++) {
                if ((i == row && j == column) || j == -1 || j == field) {
                    continue;
                }
                char cell = board[i][j];
                if (cell == mine) {
                    numberMines++;
                }

            }
        }
        return numberMines;

    }

}

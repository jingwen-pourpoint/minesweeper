package com;

import com.cell.*;

import java.util.Random;

public class BuildInitialBoard {

    public static Cell[][] initBoard(int numberMines, int size) {
        Cell[][] board = new Cell[size][size];
        setSafe(board);
        setMines(board, numberMines);
        setNumbers(board);
        return board;
    }

    private static void setSafe(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new SafeCell();
            }
        }
    }

    private static void setMines(Cell[][] board, int numberMines) {
        Random random = new Random();
        int x;
        int y;
        for (int i = 0; i < numberMines; i++) {
            do {
                x = random.nextInt(board.length);
                y = random.nextInt(board.length);
            } while (board[x][y].getType() == CellType.MINE);
            board[x][y] = new Mine();
        }
    }

    private static void setNumbers(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getType() != CellType.MINE) {
                    int minesAround = checkMines(i, j, board);
                    if (minesAround > 0) {
                        board[i][j] = new NumberCell(minesAround);
                    }
                }
            }
        }
    }

    private static int checkMines(int row, int column, Cell[][] board) {
        int numberMines = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if (i == -1 || i == board.length) {
                continue;
            }
            for (int j = column - 1; j <= column + 1; j++) {
                if ((i == row && j == column) || j == -1 || j == board.length) {
                    continue;
                }
                Cell cell = board[i][j];
                if (cell.getType() == CellType.MINE) {
                    numberMines++;
                }

            }
        }
        return numberMines;
    }
}

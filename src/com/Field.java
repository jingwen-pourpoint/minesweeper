package com;


import com.cell.Cell;
import com.cell.CellType;

import static com.Status.*;

public class Field {
    private Cell[][] board;
    private int numberMines;

    public Field(int numberMines, int size) {
        this.numberMines = numberMines;
        this.board = BuildInitialBoard.initBoard(numberMines, size);
    }

    public void displayBoard() {
        System.out.println();
        System.out.println(" │123456789│");
        System.out.println("—│—————————│");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].display());
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Status markCell(int row, int column) {
        Cell cell = board[row][column];
        if (cell.getType() == CellType.NUMBER) {
            return IMPOSSIBLE;
        }

        cell.toggleMarked();
        return gameOver() ? GAME_OVER : GAME_CONTINUE;
    }

    public boolean gameOver() {
        int realMineMarked = 0;
        int userMarked = 0;
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.isMarked()) {
                    userMarked++;
                    if (cell.getType() == CellType.MINE) {
                        realMineMarked++;
                    }
                }
            }
        }
        return realMineMarked == numberMines && realMineMarked == userMarked;
    }
}

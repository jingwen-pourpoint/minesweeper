package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().play();
    }

    public void play() {
        BuildBoard minesweeper = new BuildBoard();
        System.out.println("How many mines do you want on the field?");
        Scanner scanner = new Scanner(System.in);
        minesweeper.setSafe();
        minesweeper.setMines(scanner);
        minesweeper.setNumbers();
        minesweeper.displayBoard();
    }

}


package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().play();
    }

    public void play() {
        System.out.print("How many mines do you want on the field? ");
        Scanner scanner = new Scanner(System.in);
        int mines = scanner.nextInt();
        scanner.nextLine();
        Field mineSweeper = new Field(mines, 9);
        mineSweeper.displayBoard();

        Status status;
        do {
            System.out.print("Set/delete mines marks (x and y coordinates): ");
            String userInput = scanner.nextLine();
            String[] input = userInput.split(" ");
            int column = Integer.parseInt(input[0]);
            int row = Integer.parseInt(input[1]);
            status = mineSweeper.markCell(row - 1, column - 1);
            if (status == Status.IMPOSSIBLE) {
                System.out.println("There is a number here!");
            } else{
                mineSweeper.displayBoard();
            }
        } while (status != Status.GAME_OVER);
        System.out.println("Congratulations! You found all mines!");
    }

}


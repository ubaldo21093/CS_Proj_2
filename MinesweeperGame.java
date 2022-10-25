/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s): Vincent Cordova, Ubaldo Bogarin
 * Description: prg_02 - Minesweeper
 */

import java.util.Scanner;

public class MinesweeperGame {

    static final int BEGINNER_LEVEL     = 1;
    static final int INTERMEDIATE_LEVEL = 2;
    static final int EXPERT_LEVEL       = 3;


    // TODO #6: finish the implementation of the game according to the instructions
    public static void main(String[] args) {

        int mines;
        int size;

        Scanner s = new Scanner(System.in);
        System.out.println("Choose your difficulty number: ");
        System.out.println("BEGINNER (1)");
        System.out.println("INTERMEDIATE (2)");
        System.out.println("EXPERT (3)");
        System.out.print("Difficulty (1, 2 or 3): ");
        int diff = s.nextInt();

        if (diff == EXPERT_LEVEL) {
            size = 20;
            mines = 50;
        } else if (diff == INTERMEDIATE_LEVEL) {
            size = 15;
            mines = 25;
        } else {
            size = 10;
            mines = 10;
        }

        Minesweeper minesweeper = new Minesweeper(size, mines);

        int row = 0;
        int column = 0;


        while (!minesweeper.isGameOver()) {
            boolean flag = false;
            System.out.println("Choose a row and column in range 0 - " + (size - 1));
            System.out.print("Row, Column: ");

            String x = s.next();


            if (x.charAt(0) == '+') {
                flag = true;
                row = Integer.parseInt(x.substring(1).split(",")[0]);
                column = Integer.parseInt(x.substring(1).split(",")[1]);
                System.out.println(row);
                System.out.println(column);
            }
            else {
                row = Integer.parseInt(x.split(",")[0]);
                column = Integer.parseInt(x.split(",")[1]);
            }

            System.out.println();
            if(flag) minesweeper.reveal(row, column, true);
            else minesweeper.reveal(row, column);
            System.out.println(minesweeper);
        }
    }
}

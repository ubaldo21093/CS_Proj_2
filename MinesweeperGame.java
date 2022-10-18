/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_02 - Minesweeper
 */

import java.util.Scanner;

public class MinesweeperGame {

    static final int BEGINNER_LEVEL     = 1;
    static final int INTERMEDIATE_LEVEL = 2;
    static final int EXPERT_LEVEL       = 3;


    // TODO #6: finish the implementation of the game according to the instructions
    public static void main(String[] args) {

        int mines = 0;
        int size = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Choose your difficulty: 1, 2, 3");
        int diff = s.nextInt();

        if (diff == 3) {
            size = 20;
            mines = 50;
        } else if (diff == 2) {
            size = 15;
            mines = 25;
        } else {
            size = 10;
            mines = 10;
        }

        Minesweeper minesweeper = new Minesweeper(size, mines);
        while (!minesweeper.isGameOver()) {
            System.out.print("Pick a coordinate to check (x) (y) : ");
            String aaa = s.nextLine();
        }
    }
}
/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_02 - Minesweeper
 */

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {

    private boolean map[][];   // true if it's mined; false otherwise
    private char    board[][]; // control the game's board
    private int     size;
    private int     mines;
    private static final int MIN_SIZE = 6;
    private static final int MIN_MINES = 1;

    // TODO #1: finish the implementation of the constructor according to the instructions
    public Minesweeper(int size, int mines) {

        this.size = size;
        this.mines = mines;


        this.map = new boolean[this.size][this.size];
        this.board = new char[this.size][this.size];


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.map[i][j] = false;
            }
        }

        for (int m = 0; m < this.mines; m++) {
            hideMine();
        }

        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                this.board[k][l] = '?';
            }
        }
//        for (int k = 0; k < size; k++) {
//            for (int l = 0; l < size; l++) {
//                reveal(k, l, false);
//            }
//            System.out.println();
//        }

        System.out.println(toString());
    }

    // displays the board
    @Override
    public String toString() {
        String str = "x\\y\t";
        for (int i = 0; i < this.size; i++)
            str += i + "\t";
        str += "\n";
        for (int i = 0; i < this.size; i++) {
            str += i + "\t";
            for (int j = 0; j < this.size; j++)
                str += board[i][j] + "\t";
            str += "\n";
        }
        return str;
    }

    // tries to hide a mine at a random location; returns true if attempt was successful; false otherwise
    private boolean hideMine() {
        Random rnd = new Random();
        int x = rnd.nextInt(size);
        int y = rnd.nextInt(size);
        if (!map[x][y]) {
            map[x][y] = true;
//            System.out.print(x + " ");
//            System.out.println(y);
//            System.out.println(isMined(x, y));
            return true;
        }
        return false;
    }

    // returns true if the location is valid and mined, false otherwise
    private boolean isMined(int x, int y) {
        if (x < 0 || x > size - 1 || y < 0 || y > size - 1)
            return false;
        return map[x][y];
    }

    // returns true if the location is valid and flagged, false otherwise
    private boolean isFlagged(int x, int y) {
        if (x < 0 || x > size - 1 || y < 0 || y > size - 1)
            return false;
        return board[x][y] == '+';
    }

    // returns the number of hidden mines
    public int getMines() {
        return mines;
    }

    // TODO #2: this method should return the number of mines (immediately) around the given location
    private int minesAround(int x, int y) {
        int mineCount = 0;
        if (isMined(x-1, y-1)) mineCount++;
        if (isMined(x-1, y)) mineCount++;
        if (isMined(x, y-1)) mineCount++;
        if (isMined(x+1, y+1)) mineCount++;
        if (isMined(x+1, y)) mineCount++;
        if (isMined(x, y+1)) mineCount++;
        if (isMined(x-1, y+1)) mineCount++;
        if (isMined(x+1, y-1)) mineCount++;
        return mineCount;
    }

    // TODO #3: this method should return true if there is at least one tile in the board that reveals a mine
    public boolean isMineDetonated() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (isMined(i, j)) return false;
            }
        }
        return false;
    }

    // TODO #4: this method should return true if ALL non-mined tiles were revealed OR a mine was detonated; false otherwise
    // hint: check if the number of tiles marked with '?' matches the number of mines; also look for a "detonated" mine
    public boolean isGameOver() {
        int qCounter = 0;
        for (int i = 0; i < board.length ; i++) {
            qCounter = i;
        }
        if (qCounter == mines) return false;


        return isMineDetonated();
    }

    // same as reveal but with flag set to false
    public void reveal(int x, int y) {
        reveal(x, y, false);
    }

    // TODO #5: this method should reveal the board tile based on the given location;
    // you must use the char conventions detailed in the README file
    // if you are not implementing the flag feature (bonus points) just ignore parameter "flag"
    void reveal(int x, int y, boolean flag) {

        if (isMined(x, y)) this.board[x][y] = '*';
        else if (minesAround(x, y) == 0) this.board[x][y] = ' ';
        else if (minesAround(x, y) > 0) this.board[x][y] = (char) minesAround(x, y);
        else this.board[x][y] = '?';


//        for (int i = 0; i < x ; i++) {
//            for (int j = 0; j < y ; j++) {
//                if (isMined(i, j)) System.out.print('*');
//                else if (minesAround(i, j) == 0) System.out.print('?');
//                else if (minesAround(i, j) > 0) System.out.print(minesAround(i, j));
//                else System.out.print('?');
//            }
//            System.out.println();
//
//        }

    }
}

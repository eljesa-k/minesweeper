package com.example.minesweepergame;
import com.example.minesweepergame.GameScreen.Difficulties;
import java.util.Random;

public class BombCreator {
    private Random random = new Random();
    private static boolean[][] board;

    public BombCreator(Difficulties difficulties){
        int placedMines = 0;
        if(difficulties == Difficulties.EASY){
            this.board = new boolean[8][10];
            // Loop until 10 mines have been placed
            while (placedMines < 10) {
                // Generate random x and y coordinates for a cell on the game board
                int i = random.nextInt(8);
                int j = random.nextInt(10);
                // If the cell at (i, j) does not already have a mine
                if (!board[i][j]) {
                    // Place a mine at (i, j)
                    board[i][j] = true;
                    // Increase the count of placed mines
                    placedMines++;
                }
            }
        }
        else if(difficulties == Difficulties.MEDIUM){
            this.board = new boolean[14][18];
            while (placedMines < 15) {
                int i = random.nextInt(14);
                int j = random.nextInt(18);
                if (!board[i][j]) {
                    board[i][j] = true;
                    placedMines++;
                }
            }
        }
        else {
            this.board = new boolean[20][24];
            while (placedMines < 25) {
                int i = random.nextInt(20);
                int j = random.nextInt(24);
                if (!board[i][j]) {
                    board[i][j] = true;
                    placedMines++;
                }
            }
        }
    }

    public boolean[][] getBoard() {
        return board;
    }

    public static void print(boolean[][] mat) {
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    public boolean checkCell(int i, int j){
        return board[i][j];
    }

    public static void main(String[] args) {
        BombCreator b = new BombCreator(Difficulties.EASY);
        print(b.getBoard());
    }
}



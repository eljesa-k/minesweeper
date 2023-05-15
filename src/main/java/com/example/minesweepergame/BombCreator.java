package com.example.minesweepergame;
import com.example.minesweepergame.GameScreen.Difficulties;
import com.example.minesweepergame.GameScreen.Difficulty;

import java.util.Map;
import java.util.Random;

public class BombCreator {
    private Random random = new Random();
    private static boolean[][] board;
    public static int[][] surroundingMines;
    public BombCreator(Difficulties difficulties){

        int placedMines = 0;

        Map<String, Integer> difficultyDetails = Difficulty.getDiff(difficulties);
        int rows = difficultyDetails.get("rows");
        int columns = difficultyDetails.get("columns");
        int numBombs = difficultyDetails.get("nr_bombs");
        this.board = new boolean[rows][columns];
        this.surroundingMines = new int[rows][columns];

        while (placedMines < numBombs) {
            int i = random.nextInt(rows);
            int j = random.nextInt(columns);
            if (!board[i][j]) {
                board[i][j] = true;
                placedMines++;
            }
        }
    }

    public boolean[][] getBoard() {
        return board;
    }

    public static void print(boolean[][] mat) {
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] ? " o " : " - ");
            System.out.println();
        }
    }

    public static void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(" "+mat[i][j]+" ");
            System.out.println();
        }
    }

    public boolean checkCell(int i, int j){
        return board[i][j];
    }

    //metoda e elit qe metem me kqyr
    public int checkNeighbors(int row, int col){
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
                    if((board[i][j])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void locateBombs(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                if((board[i][j])) {
                    System.out.print(" "+"*"+" ");
                    surroundingMines[i][j]=9;
                } else {
                    System.out.print(" "+countNeighbors(i, j)+" ");
                    surroundingMines[i][j]=countNeighbors(i, j);
                }
            }
            System.out.println();
        }
    }

    private static int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
                    if((board[i][j])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BombCreator b = new BombCreator(Difficulties.EASY); //MEDIUM or HARD
        System.out.println("this prints the random board me mines o");
        print(b.getBoard());
        System.out.println();
        System.out.println("this prints mines me * edhe cila cell sa neighbor bomba i ka");
        locateBombs();
        System.out.println();
        System.out.println("the returned int array");
        print(surroundingMines);
//        System.out.println(b.checkNeighbors(0,0));
//        System.out.println(b.checkNeighbors(0,0));
//        System.out.println(b.checkNeighbors(3,3));
//        System.out.println(b.checkNeighbors(1,2));
//        System.out.println(b.checkNeighbors(7,8));
//        System.out.println(b.checkNeighbors(5,4));
//        System.out.println(b.checkNeighbors(7,9));
    }
}



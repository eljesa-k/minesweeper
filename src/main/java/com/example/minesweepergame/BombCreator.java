package com.example.minesweepergame;
import com.example.minesweepergame.GameScreen.Difficulties;
import java.util.Random;

public class BombCreator {
    private Random random = new Random();
    private static boolean[][] board;
    public static int[][] surroundingMines;
    public BombCreator(Difficulties difficulties){
        int placedMines = 0;
        if(difficulties == Difficulties.EASY){
            this.board = new boolean[8][10];
            this.surroundingMines = new int[8][10];
            while (placedMines < 10) {
                int i = random.nextInt(8);
                int j = random.nextInt(10);
                if (!board[i][j]) {
                    board[i][j] = true;
                    placedMines++;
                }
            }
        }
        else if(difficulties == Difficulties.MEDIUM){
            this.board = new boolean[14][18];
            this.surroundingMines = new int[14][18];
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
            this.surroundingMines = new int[20][24];
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
    public int checkNeighbors(int i, int j){
        int n = 0;

        for (int k = -1; k <= 1; k++) {
            if( i + k < 0 || i + k >= board.length)
                continue;
            for (int l = -1; l <= 1; l++) {
                if(j + l < 0 || j + l >= board[0].length)
                    continue;
                if(checkCell(i + k, i + l) && i != 0 && j != 0)
                    n++;
            }
        }

        return n;
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



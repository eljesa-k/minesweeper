package com.example.minesweepergame.GameScreen;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Board extends GridPane {
    private int rows;
    private int columns;
    private GameViewController controller;

    public Board(int rows, int columns, GameViewController controller){
        this.setHgap(1.5);
        this.setVgap(1.5);
        this.rows = rows;
        this.columns = columns;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                this.add(new Cell(this), j , i);
            }
        }
        this.controller = controller;
    }
    protected void endGame(){
        // todo: shfaqi krejt bombat
        try{
            Thread.sleep(1500);
        }catch (InterruptedException e){}
        controller.endGame();

    }
}

package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.BombCreator;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Map;

public class Board extends GridPane {
    private int rows;
    private int columns;
    private GameViewController controller;
    private BombCreator bombCreator;

    private Cell[][] cellArray;

    public Board(GameViewController controller, Difficulties diff){
        this.setHgap(1.5);
        this.setVgap(1.5);
        Map<String, Integer> difficultyDetails = Difficulty.getDiff(diff);
        this.rows = difficultyDetails.get("rows");
        this.columns = difficultyDetails.get("columns");
        this.bombCreator = new BombCreator(Difficulties.EASY);
        cellArray = new Cell[rows][columns];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                Cell cell = new Cell(this, bombCreator.checkCell(i,j), bombCreator.checkNeighbors(i, j));
                this.add(cell, j , i);
                this.cellArray[i][j]=cell;
            }
        }
        this.controller = controller;
        System.out.println(cellArray);
    }
    protected void endGame(){
        // todo: shfaqi krejt bombat
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[0].length; j++) {
                cellArray[i][j].open();
            }
        }
        try{
            Thread.sleep(1500);
            //controller.endGame();
        }
        catch (InterruptedException e){}
    }
}

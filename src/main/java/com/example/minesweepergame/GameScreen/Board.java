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
    private int cellsToOpen;
    private int unFlagged;

    public Board(GameViewController controller, Difficulties diff){
        this.setHgap(1.5);
        this.setVgap(1.5);
        Map<String, Integer> difficultyDetails = Difficulty.getDiff(diff);
        this.rows = difficultyDetails.get("rows");
        this.columns = difficultyDetails.get("columns");
        this.cellsToOpen = rows * columns - difficultyDetails.get("nr_bombs");
        this.unFlagged = difficultyDetails.get("nr_bombs");
        this.bombCreator = new BombCreator(diff);
        cellArray = new Cell[rows][columns];

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                Cell cell = new Cell(this, bombCreator.checkCell(i,j), bombCreator.checkNeighbors(i, j), i, j);
                this.add(cell, j , i);
                this.cellArray[i][j]=cell;
            }
        }
        this.controller = controller;
    }
    protected void endGame(){
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[0].length; j++) {
                cellArray[i][j].open();
            }
        }
        controller.endGame(false);
    }
    protected void openNeighbors(int x, int y){
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if(i >= 0 && j >= 0 && i < cellArray.length && j < cellArray[0].length && (x == i ^ y == j))
                    this.cellArray[i][j].open();
            };
        }

    }
    protected void addOpenedCell(){
        this.cellsToOpen--;
        System.out.println(cellsToOpen);
        if(this.cellsToOpen == 0){
            controller.endGame(true);
        }
    }
    protected void addFlagged(){
        this.unFlagged --;
        controller.setNumBombs(this.unFlagged);
    }
}

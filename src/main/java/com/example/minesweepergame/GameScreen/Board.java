package com.example.minesweepergame.GameScreen;
import com.example.minesweepergame.BombCreator;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import javax.swing.*;
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
        System.out.println(cellArray);
    }
    protected void endGame(){
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[0].length; j++) {
                cellArray[i][j].open();
            }
        }
        Delay(5000L);
        controller.endGame();
        Delay(5000L);
    }

    void Delay(Long ms){
        Long dieTime = System.currentTimeMillis()+ms;
        while(System.currentTimeMillis()<dieTime){}
    }

    public void showPane() {
        JOptionPane.showMessageDialog(null, "output");
    }

    protected void openNeighbors(int x, int y){
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if(i >= 0 && j >= 0 && i < cellArray.length && j < cellArray[0].length && (x == i ^ y == j))
                    this.cellArray[i][j].open();
            };
        }

    }
}

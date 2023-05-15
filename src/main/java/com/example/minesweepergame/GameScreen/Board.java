package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.BombCreator;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.Map;

public class Board extends GridPane {
    private int rows;
    private int columns;
    private GameViewController controller;
    private BombCreator bombCreator;

    public Board(GameViewController controller, Difficulties diff){
        this.setHgap(1.5);
        this.setVgap(1.5);
        Map<String, Integer> difficultyDetails = Difficulty.getDiff(diff);
        this.rows = difficultyDetails.get("rows");
        this.columns = difficultyDetails.get("columns");
        this.bombCreator = new BombCreator(Difficulties.EASY);

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                this.add(new Cell(this, bombCreator.checkCell(i,j), bombCreator.checkNeighbors(i, j)), j , i);
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

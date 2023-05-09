package com.example.minesweepergame.GameScreen;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Board extends GridPane {
    private int rows;
    private int columns;

    public Board(int rows, int columns){
        this.setHgap(1.5);
        this.setVgap(1.5);
        this.rows = rows;
        this.columns = columns;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                this.add(new Cell(), j , i);
            }
        }
    }
}

package com.example.minesweepergame.GameScreen;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    public Cell(){
        this.setWidth(20);
        this.setHeight(20);

        this.setFill(Color.rgb(79, 188, 255, 1));
        this.setArcHeight(5);
        this.setArcWidth(5);
        this.getStyleClass().add(".cell");

    }
}

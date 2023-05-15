package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.MainController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Cell extends Button implements  EventHandler<MouseEvent>{
    //private static final String HOVERED_BUTTON_STYLE = "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #4fbcff; -fx-border-radius: 5px; -fx-pref-width: 25; -fx-pref-height: 20;";
    private boolean isBomb = true;
    private int neighborBombs = 3;
    private boolean isOpen;
    private boolean isFlagged;
    private Board board;
    public Cell(Board board, boolean isBomb, int neighborBombs){
        this.board = board;
        this.isBomb = isBomb;
        this. neighborBombs = neighborBombs;
        this.setStyle(IDLE_BUTTON_STYLE);
        //this.getStyleClass().add(".cell");
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        this.setMinWidth(27);
        this.setMaxWidth(27);
        this.setMaxHeight(27);
        this.setMinHeight(27);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(isOpen || isFlagged)
            return;
        if(mouseEvent.getButton() == MouseButton.PRIMARY && !isFlagged){
            isOpen = true;
            if(isBomb){
                this.setStyle("-fx-background-color: #FF2519FF;");
                this.setBackgroundImage("bomb");
                //board.endGame();
            }else{
                this.setStyle("-fx-background-color: #eef0f2;");
                this.setText(neighborBombs > 0 ? neighborBombs + "" : " ");
            }
        }
        else if(mouseEvent.getButton() == MouseButton.SECONDARY){
//            if(!isFlagged){
                isFlagged = true;
                this.setStyle("-fx-background-color: #fed684;");
                this.setBackgroundImage("flag");
//            }else{
//                this.isFlagged = false;
//                this.setStyle(IDLE_BUTTON_STYLE);
//            }
        }
    }

    private void setBackgroundImage(String img){
        this.setGraphic(new ImageView(new Image(MainController.class.getResource("img/"+img+".png").toString(), 25, 25, false, false)));
    }
}

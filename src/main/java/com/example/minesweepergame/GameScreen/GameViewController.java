package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;

public class GameViewController {
    private Pane boardView;
    public double width;
    public double height;

    public GameViewController(Difficulties diff){
        FXMLLoader fxmlLoader =
                new FXMLLoader(MainController.class.getResource("game-screen/game-screen.fxml"));
        try{
            fxmlLoader.load();}
        catch (Exception e){
            e.getMessage();
        }

        boardView = fxmlLoader.getRoot();


        int rows;
        int cols;
        int nr_bombs;
        switch (diff){
            case EASY -> {
                cols = 10;
                rows = 8;
                nr_bombs = 10;

            }
            case MEDIUM -> {
                cols = 18;
                rows = 14;
                nr_bombs = 40;

            }
            default -> {
                cols = 24;
                rows = 20;
                nr_bombs = 90;
            }

        }
        Board board = new Board(rows, cols);
        boardView.getChildren().add(board);
        this.width = cols * 28.5 -1;
        this.height = rows * 28.5 -1;
    }

    public Pane getBoardView() {
        return this.boardView;
    }
}

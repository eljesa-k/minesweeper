package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GameScreenView {
    private Pane boardView;
    public double width;
    public double height;

    public GameScreenView(Difficulties diff) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource("game-screen/game-screen.fxml"));
        fxmlLoader.load();

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
        this.width = cols * 21.5 -1;
        this.height = rows * 21.5 -1;
    }

    public Pane getBoardView() {
        return this.boardView;
    }
//    public double getWidth(){
//        return boardView.getWidth();
//    }
}

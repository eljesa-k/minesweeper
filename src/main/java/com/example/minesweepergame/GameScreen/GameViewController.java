package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameViewController {
    private Pane boardView;
    public double width;
    public double height;
    private MainController controller;
    private GameView gameView;

    public GameViewController(Difficulties diff, MainController controller){
        this.controller = controller;

        FXMLLoader fxmlLoader =
                new FXMLLoader(MainController.class.getResource("game-screen/game-screen.fxml"));
        try{
            fxmlLoader.load();}
        catch (Exception e){
            e.getMessage();
        }

        boardView = fxmlLoader.getRoot();
        gameView = fxmlLoader.getController();

        Board board = new Board(this, diff);
        boardView.getChildren().add(board);
        this.width = Difficulty.getDiff(diff).get("columns") * 28.5 -1;
        this.height = Difficulty.getDiff(diff).get("rows") * 28.5 -1;
    }

    public Pane getBoardView() {
        return this.boardView;
    }
    protected void endGame(boolean isWin){
        controller.endGame(gameView.getTime(), isWin);
    }
    protected void setNumBombs(int leftBombs){
        if(leftBombs >= 0)
            this.gameView.setNumBombsText(leftBombs);
    }
    protected void endTime(){
        gameView.endTime();
    }
}

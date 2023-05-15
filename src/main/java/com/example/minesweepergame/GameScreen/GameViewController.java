package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;

public class GameViewController {
    private Pane boardView;
    public double width;
    public double height;
    private MainController controller;

    public GameViewController(Difficulties diff, MainController controller){
        FXMLLoader fxmlLoader =
                new FXMLLoader(MainController.class.getResource("game-screen/game-screen.fxml"));
        try{
            fxmlLoader.load();}
        catch (Exception e){
            e.getMessage();
        }

        boardView = fxmlLoader.getRoot();

        Board board = new Board(this, diff);
        boardView.getChildren().add(board);
        this.width = Difficulty.getDiff(diff).get("columns") * 28.5 -1;
        this.height = Difficulty.getDiff(diff).get("rows") * 28.5 -1;
        this.controller = controller;
    }

    public Pane getBoardView() {
        return this.boardView;
    }
    protected void endGame(){
        // todo: njeheso piket
        try{
            Thread.sleep(3000);
            //controller.endGame();
        }
        catch (InterruptedException e){}
        //controller.endGame(200, true);
    }
}

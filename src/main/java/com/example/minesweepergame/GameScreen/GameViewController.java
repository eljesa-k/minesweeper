package com.example.minesweepergame.GameScreen;

import com.example.minesweepergame.MainController;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javax.swing.*;

public class GameViewController {
    Time time = new Time(new CurrentTime().currentTime());
    Timeline timeline ;

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
        //System.out.println(((BorderPane)boardView.getChildren().get(0)).getLeft());
        //timerText=(Text)((BorderPane)boardView.getChildren().get(0)).getLeft();
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
            Thread.sleep(0000);
            controller.endGame(222, true);
        }
        catch (InterruptedException e){}
    }

    public void showPane() {
        JOptionPane.showMessageDialog(null, "output");
    }
}

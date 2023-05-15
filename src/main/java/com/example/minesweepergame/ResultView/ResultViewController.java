package com.example.minesweepergame.ResultView;

import com.example.minesweepergame.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


public class ResultViewController {
    private Pane resultView;

    public ResultViewController(MainController controller, String playerName, String time, boolean isWin){
        FXMLLoader fxmlLoader =
                new FXMLLoader(MainController.class.getResource("game-result-view.fxml"));
        try{
            fxmlLoader.load();}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        ResultView resultView = fxmlLoader.getController();
        resultView.setPlayerName(playerName);
        resultView.setPlayerScore(time);
        resultView.setGameWon(isWin);
        resultView.setController(controller);
        this.resultView = fxmlLoader.getRoot();
    }
    public Pane getResultView(){
        return this.resultView;
    }
}

package com.example.minesweepergame.ResultView;

import com.example.minesweepergame.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ResultView {
    @FXML
    TextField playerName;
    @FXML
    TextField playerScore;
    @FXML
    Text gameWon;
    @FXML
    Button quitGame;
    private MainController controller;

    public void setPlayerName(String playerName) {
        this.playerName.setText(playerName);
    }
    public void setPlayerScore(int playerScore){
        this.playerScore.setText(String.valueOf(playerScore));
    }
    public void setGameWon(boolean isWon){
        if (isWon) this.gameWon.setText("You Won!");
        else this.gameWon.setText("You Lost!");
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public void quitGame(){
        controller.quitGame();
    }
    public void newGame(){
        controller.newGame();
    }
}

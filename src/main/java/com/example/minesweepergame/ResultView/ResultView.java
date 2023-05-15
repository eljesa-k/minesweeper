package com.example.minesweepergame.ResultView;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ResultView {
    @FXML
    TextField playerName;
    @FXML
    TextField playerScore;
    @FXML
    Text gameWon;

    public void setPlayerName(String playerName) {
        System.out.println(playerName);
        this.playerName.setText(playerName);
    }
    public void setPlayerScore(int playerScore){
        System.out.println(playerScore);
        this.playerScore.setText(String.valueOf(playerScore));
    }
    public void setGameWon(boolean isWon){
        if (isWon)
            this.gameWon.setText("You Won!");
        else this.gameWon.setText("You Lost!");
        //System.out.println(gameWon.toString());
    }
}

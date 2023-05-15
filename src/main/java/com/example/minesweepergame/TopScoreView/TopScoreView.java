package com.example.minesweepergame.TopScoreView;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TopScoreView {
    @FXML
    Text currentRank;
    @FXML
    TextField playerName1;
    @FXML
    TextField playerName2;
    @FXML
    TextField playerName3;
    @FXML
    TextField topScore1;
    @FXML
    TextField topScore2;
    @FXML
    TextField topScore3;

    public void setCurrentRank(int currentRank) {
        this.currentRank.setText(String.valueOf(currentRank));
        System.out.println("Current player rank: " + currentRank);
    }

    public void setPlayerName1(String playerName1) {
        this.playerName1.setText(playerName1);
        System.out.println("Player ranked #1: " + playerName1);
    }

    public void setPlayerName2(String playerName2) {
        this.playerName2.setText(playerName2);
        System.out.println("Player ranked #2: " + playerName2);
    }

    public void setPlayerName3(String playerName3) {
        this.playerName3.setText(playerName3);
        System.out.println("Player ranked #3: " + playerName3);
    }

    public void setTopScore1(int topScore1) {
        this.topScore1.setText(String.valueOf(topScore1));
        System.out.println("Player #1 score: " + topScore1);
    }

    public void setTopScore2(int topScore2) {
        this.topScore2.setText(String.valueOf(topScore2));
        System.out.println("Player #2 score: " + topScore2);
    }

    public void setTopScore3(int topScore3) {
        this.topScore3.setText(String.valueOf(topScore3));
        System.out.println("Player #3 score: " + topScore3);
    }
}

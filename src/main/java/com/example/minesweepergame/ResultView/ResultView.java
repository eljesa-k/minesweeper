package com.example.minesweepergame.ResultView;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ResultView {
    @FXML
    TextField playerName;

    public void setPlayerName(String playerName) {
        System.out.println(playerName);
        this.playerName.setText(playerName);
    }
}

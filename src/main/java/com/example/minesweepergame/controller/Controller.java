package com.example.minesweepergame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private String playerNameValue = "player-1";
    private int playerScoreValue = 30;
    @FXML
    public void setPlayerName(String playerNameValue) {
        this.playerNameValue = playerNameValue;
    }
    @FXML
    public String getPlayerName() {
        return playerNameValue;
    }
    @FXML
    public String getPlayerNameValue() {
        return playerNameValue;
    }
    @FXML
    public void setPlayerNameValue(String playerNameValue) {
        this.playerNameValue = playerNameValue;
    }

}
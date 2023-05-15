package com.example.minesweepergame.GameScreen;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class GameView {
    @FXML
    Text numBombsText;

    @FXML
    Text timerText;

    protected void setNumBombsText(int numBombsText) {
        this.numBombsText.setText(numBombsText + "");
    }

    protected void setTimerText(String timerText) {
        this.timerText.setText(timerText);
    }
    int seconds;
    int minutes;
    Timer timer;

    public GameView(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    seconds++;
                    minutes += seconds /60;
                    seconds %= 60;
                    setTimerText(String.format("%02d:%02d", minutes, seconds));
                });
            }
        }, 0, 1000);
    }
    public String getTime(){
        return String.format("%02d:%02d", minutes, seconds);
    }
    protected void endTime(){
        timer.cancel();
    }
}

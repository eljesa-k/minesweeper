package com.example.minesweepergame;

import com.example.minesweepergame.GameScreen.Difficulties;
import com.example.minesweepergame.GameScreen.GameScreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameScreenView gameScreen = new GameScreenView(Difficulties.EASY);
        Scene scene = new Scene(gameScreen.getBoardView(), gameScreen.width + 200, gameScreen.height + 150);
        scene.getStylesheets().add(getClass().getResource("style/style.css").toExternalForm());
        stage.setScene(scene);
//        stage.setResizable(false);
        stage.setTitle("Minesweeper");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

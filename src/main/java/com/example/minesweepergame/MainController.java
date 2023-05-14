package com.example.minesweepergame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WelcomeViewController welcome = new WelcomeViewController();
        stage.setScene(new Scene(welcome.getWelcomeView()));
        stage.setTitle("Minesweeper");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

package com.example.minesweepergame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WelcomeViewController welcome = new WelcomeViewController(this);
        stage.setScene(new Scene(welcome.getWelcomeView()));
        stage.setTitle("Minesweeper");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void ok(){
        System.out.println("ok from main controller");
    }
}

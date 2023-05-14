package com.example.minesweepergame;

import com.example.minesweepergame.GameScreen.Difficulties;
import com.example.minesweepergame.GameScreen.GameViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController extends Application {

    private String name;

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        WelcomeViewController welcome = new WelcomeViewController(this);
        stage.setScene(new Scene(welcome.getWelcomeView()));
        stage.setTitle("Minesweeper");
        stage.show();
        this.stage=stage;
    }

    public static void main(String[] args) {
        launch();
    }

    public void ok(){
        System.out.println("ok from main controller");
    }

    public void startGame(String name, Difficulties difficulty){
        GameViewController game = new GameViewController(difficulty);
        this.name=name;
        stage.setScene(new Scene(game.getBoardView(), game.width +200, game.height+150));
        stage.setResizable(false);
    }
}

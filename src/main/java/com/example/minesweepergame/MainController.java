package com.example.minesweepergame;

import com.example.minesweepergame.GameScreen.Difficulties;
import com.example.minesweepergame.GameScreen.GameViewController;
import com.example.minesweepergame.ResultView.ResultViewController;
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
        this.stage = stage;
       // this.endGame(200, true);
    }

    public static void main(String[] args) {
        launch();
    }

    public void startGame(String name, Difficulties difficulty){
        GameViewController game = new GameViewController(difficulty, this);
        this.name=name;
        stage.setScene(new Scene(game.getBoardView(), game.width +200, game.height+150));
        stage.setResizable(false);
    }

    public void endGame(int score, boolean isWin){
        ResultViewController result = new ResultViewController(this, name, score);
        stage.setResizable(true);
        stage.setScene(new Scene(result.getResultView()));
    }
}

package com.example.minesweepergame;

import com.example.minesweepergame.GameScreen.Difficulties;
import com.example.minesweepergame.GameScreen.GameViewController;
import com.example.minesweepergame.ResultView.ResultViewController;
import com.example.minesweepergame.WelcomeScreen.WelcomeViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController extends Application {

    private String name;

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("Minesweeper");

        this.newGame();
        stage.show();
       //this.endGame(200, true);
    }

    public static void main(String[] args) {
        launch();
    }

    public void newGame(){
        WelcomeViewController welcome = new WelcomeViewController(this);
        stage.setScene(new Scene(welcome.getWelcomeView()));
    }
    public void startGame(String name, Difficulties difficulty){
        GameViewController game = new GameViewController(difficulty, this);
        this.name=name;
        stage.setScene(new Scene(game.getBoardView(), game.width < 440 ? 640 : game.width + 200 , game.height < 350 ? 500 : game.height + 150));
        stage.setResizable(false);
    }

    public void endGame(int score, boolean isWin){
        ResultViewController result = new ResultViewController(this, name, score, isWin);
        stage.setResizable(true);
        stage.setScene(new Scene(result.getResultView()));
    }

    public void quitGame(){
        // save results
        System.exit(1);
    }

}

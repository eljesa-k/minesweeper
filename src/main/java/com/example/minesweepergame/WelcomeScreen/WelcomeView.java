//  I RONES

package com.example.minesweepergame.WelcomeScreen;


import com.example.minesweepergame.GameScreen.Difficulties;
import com.example.minesweepergame.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WelcomeView {

    private MainController controller;
    @FXML
    private TextField typeNameField;
    @FXML
    private Button easyButton = new Button();
    @FXML
    private Button mediumButton=new Button();
    @FXML
    private Button hardButton= new Button();

    private Pane welcomeView;

    String name;

    public void startGameEasyAction(ActionEvent event) {
        name = typeNameField.getText();
        if(name != null && !name.equals(""))
            controller.startGame(name, Difficulties.EASY);
    }
    public void startGameMediumAction(ActionEvent event){
        name = typeNameField.getText();
        if(name != null && !name.equals(""))
            controller.startGame(name, Difficulties.MEDIUM);
    }
    public void startGameHardAction(ActionEvent event){
        name = typeNameField.getText();
        if(name != null && !name.equals(""))
            controller.startGame(name, Difficulties.HARD);
    }

    public Pane getWelcomeView(){
        return this.welcomeView;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }
}

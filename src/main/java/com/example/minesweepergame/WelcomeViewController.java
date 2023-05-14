package com.example.minesweepergame;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WelcomeViewController {
    private Pane welcomeView;
    public WelcomeViewController() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeView.class.getResource("welcomeViewUI.fxml"));
        try{
            fxmlLoader.load();}
        catch (Exception e){
            e.getMessage();
        }
        this.welcomeView=fxmlLoader.getRoot();

    }

    public Pane getWelcomeView() {
        return welcomeView;
    }
}

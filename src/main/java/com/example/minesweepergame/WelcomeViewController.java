package com.example.minesweepergame;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WelcomeViewController {
    private Pane welcomeView;
    public WelcomeViewController(MainController controller){

        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeView.class.getResource("welcomeViewUI.fxml"));
        try{
            fxmlLoader.load();}
        catch (Exception e){
            e.getMessage();
        }

        this.welcomeView=fxmlLoader.getRoot();
        WelcomeView w = fxmlLoader.getController();
        w.setController(controller);
//        View view=load.getController();
//        FXMLLoader load=new FXMLLoader(url);
//        Parent root=null;
//
//        try {
//            root=load.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        View view=load.getController();
//        view.setController(controller);

    }

    public Pane getWelcomeView() {
        return welcomeView;
    }
}

//  I RONES

package com.example.minesweepergame;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class WelcomeViewController extends Application {

    @FXML
    private TextField typeNameField;
    @FXML
    private Button easyButton = new Button();
    @FXML
    private Button mediumButton=new Button();
    @FXML
    private Button hardButton= new Button();

    String name;

    public void startGameEasyAction(ActionEvent event){
        name = typeNameField.getText();
        System.out.println(name);
        System.out.println("easy");
    }
    public void startGameMediumAction(ActionEvent event){
        name = typeNameField.getText();
        System.out.println(name);
        System.out.println("medium");
    }
    public void startGameHardAction(ActionEvent event){
        name = typeNameField.getText();
        System.out.println(name);
        System.out.println("hard");
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeViewController.class.getResource("welcomeViewUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 610, 450);
        //scene.getStylesheets().add(getClass().getResource("newStyle.css").toExternalForm());
        stage.setTitle("Minesweeper");
        stage.setScene(scene);
        stage.show();

        DropShadow shadow = new DropShadow();
        easyButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) ->{
            easyButton.setEffect(shadow);
        });
        mediumButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) ->{
            mediumButton.setEffect(shadow);
        });
        hardButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) ->{
            hardButton.setEffect(shadow);
        });

//        button.setOnAction(e -> {
//            String name = textField1.getText();
//        });
    }


    public static void main(String[] args) {
        launch();
    }

}

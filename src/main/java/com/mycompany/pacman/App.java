package com.mycompany.pacman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane(); 
        root.setStyle("-fx-background-color: black;");
        Scene scene = new Scene(root); 
        stage.setScene(scene);
        stage.setTitle("PacMan");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
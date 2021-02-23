package com.mycompany.pacman;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
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
    public void start(Stage stage) throws FileNotFoundException {
        /* Testing av figurer skjer her */
        Pane root = new Pane(); 
        root.setStyle("-fx-background-color: black;");
        
        /* Ghost superklasse */
        String path = "C:\\Users\\Mats Engesund\\Documents\\NetBeansProjects\\PacMan\\src\\main\\java\\com\\mycompany\\pacman\\blue.png";
        Ghost red = new Ghost(path);
        root.getChildren().add(red.getImageView());
        
        
        /* Scene-oppsett */
        Scene scene = new Scene(root, 500, 500); 
        stage.setScene(scene);
        stage.setTitle("PacMan");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
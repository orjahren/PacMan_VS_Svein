package com.mycompany.pacman;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 300); 
        stage.setScene(scene);
        stage.setTitle("Pac-Man");
        
        
        /* Selveste Pac-Man figuren*/
        Arc pacman = new Arc(50, 100, 25, 25, 15, 300);
        //Arc pacman = new Arc(100, 200, 50, 50, 30, 300);
        pacman.setStroke(Color.BLACK);
        pacman.setFill(Color.YELLOW);
        pacman.setType(ArcType.ROUND);
        root.getChildren().add(pacman); 
        
        
        /* Gaping */
        Timeline gaping = new Timeline();
        gaping.setCycleCount(Timeline.INDEFINITE);
        gaping.setAutoReverse(true);
        KeyValue vinkel = new KeyValue(pacman.startAngleProperty(), 20);
        KeyValue bue = new KeyValue(pacman.lengthProperty(), 360); 
        KeyFrame kf = new KeyFrame(Duration.millis(300), vinkel, bue); 
        gaping.getKeyFrames().add(kf); 
        
        
        /* Utførelse av åpning og lukking av munn */
        ParallelTransition animasjon = new ParallelTransition(); 
        animasjon.getChildren().add(gaping); 
        
        
        /* Start av animasjon og show */
        stage.show();
        animasjon.play();
    }

    public static void main(String[] args) {
        launch();
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacman;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author mjoen
 */
public class MrPac {
    
    /*
        Dette er klassen til selve Pac-Man figuren. Vet ikke helt om det skal 
        være et bibliotek eller objekt. Vanskelig å plasere et objekt i javafx
        da det kun finnes en størelse på pacman. Kan prøve å lage en getmetode 
        i konstruktøren
    */
    
    
    protected Arc pacman; 
    protected Timeline gaping; 
    protected ParallelTransition animation; 
    //protected SequentialTransition moving; 
    
    
    public MrPac() {
        setMrPac();
        setMovement();
        setGaping();
        setAnimation();
    }
    
    
    public void setGaping() {
        gaping = new Timeline(); 
        gaping.setCycleCount(Timeline.INDEFINITE);
        gaping.setAutoReverse(true);
        
        KeyValue angle = new KeyValue(pacman.startAngleProperty(), 10); 
        KeyValue bow = new KeyValue(pacman.lengthProperty(), 360); 
        
        KeyFrame kf = new KeyFrame(Duration.millis(200), angle, bow);
        gaping.getKeyFrames().add(kf);
    }
    
    public Timeline getGaping() {
        return gaping; 
    }
    
    
    public void setAnimation() {
        animation = new ParallelTransition(); 
        animation.getChildren().add(gaping); 
    }
    
    public void startAnimation() {
        animation.play();
    }
    
    
    public void setMovement() {
        pacman.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case DOWN: 
                    pacman.setCenterY(pacman.getCenterY() + 10);
                    break; 
                case UP: 
                    pacman.setCenterY(pacman.getCenterY() - 10);
                    break; 
                case LEFT: 
                    pacman.setCenterX(pacman.getCenterX() - 10);
                    break; 
                case RIGHT: 
                    pacman.setCenterX(pacman.getCenterX() + 10);
                    break; 
            }
        });
        
        pacman.requestFocus();
    }
    
    
    public void setMrPac() {
        pacman = new Arc(50, 100, 25, 25, 15, 300); 
        pacman.setStroke(Color.BLACK);
        pacman.setFill(Color.YELLOW);
        pacman.setType(ArcType.ROUND);
    }
    
    public Arc getMrPac() {
        return pacman; 
    }
    
}

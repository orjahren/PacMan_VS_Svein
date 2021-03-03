/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacman;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
/**
 *
 * @author Mats Engesund
 */
public class Ghost {
    
    /*
        Dette er superklassen til spøkelsene 
        Hvert enkelt spørelse (rød, rosa, cyan og oransje) får sin 
        egen subklasse av denne. Men hvilke felles egenskaper har disse: 
        * path, filestream, image, imageView, 
        * størelse
        
        Vi har nå rød, oransje/gul, grønn og blå. ALLE ER PÅ PLASS
    */
    
    protected String path; 
    protected double xpos, ypos; 
    protected Image image; 
    protected FileInputStream stream; 
    protected ImageView view;
    protected final int SIZE = 50; // alle blir like store 

    protected static LinkedList<Ghost> l = new LinkedList<>();
    
    public Ghost(String path, double xpos, double ypos) throws FileNotFoundException {
        this.path   = path; 
        this.xpos   = xpos; 
        this.ypos   = ypos;
        stream      = new FileInputStream(path); 
        image       = new Image(stream); 
        
        setImageView(SIZE, SIZE);

        l.add(this);
    }

    protected  Integer[] sjekkPos(Ghost s) {
        Integer[] ut = new Integer[2];
        boolean klarX, klarY;
        for(Ghost g : l) {
            /*
            if(s.xpos + this.getSpeed()) {

            }

             */
        }
        return ut;
    }

    protected double getSpeed() {
        return 1;
    }
    
    
    protected ImageView getImageView() {
        return view; 
    }
    
    
    protected void setImageView(double sizeX, double sizeY) {
        view = new ImageView(getImage());
        view.setFitHeight(SIZE);
        view.setFitWidth(SIZE);
        view.setX(xpos);
        view.setY(ypos);
    }
    
    
    protected Image getImage() {
        return image; 
    }
    
    
    protected void chase(MrPac pacman) {
        pacman.setMovement();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double pacPosX = pacman.getMrPac().getCenterX();
                double pacPosY = pacman.getMrPac().getCenterY();

                double ghostX = view.getX();
                double ghostY = view.getY();

                double distanceX = Math.abs(pacPosX - view.getX());
                double distanceY = Math.abs(pacPosY - view.getY());

                if (distanceX > distanceY) {
                    if (ghostX > pacPosX) {
                        view.setX(ghostX - getSpeed());
                    } 
                    else {
                        view.setX(ghostX + getSpeed());
                    }
                } 
                else {
                    if(ghostY > pacPosY) {
                        view.setY(ghostY - getSpeed());
                    } 
                    else {
                        view.setY(ghostY + getSpeed());
                    }
                }
            }
        }.start();
    }
    
}

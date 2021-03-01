/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacman;

import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;

/**
 *
 * @author mjoen
 */
public class Red extends Ghost {
    
    protected double xpos, ypos; 
    
    
    public Red(String path, double xpos, double ypos) throws FileNotFoundException {
        super(path, xpos, ypos); 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacman;

import java.io.FileNotFoundException;
import javafx.animation.PathTransition;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author mjoen
 */
public class Red extends Ghost {
    
    /*
        Kan være jeg surrer, men mener det er rød som er hard på gassen når det
        kommer til å jage pacman. Gidder ikke sjekke nå, det er bestemt.
    */
    
    
    //protected double xpos, ypos; 
    //protected double pacPosX, pacPosY;
    
    
    public Red(String path, double xpos, double ypos) throws FileNotFoundException {
        super(path, xpos, ypos); 
    }
    
    
    protected void chase(MrPac pacman) { 
        double pacPosX = pacman.getPosX(); 
        double pacPosY = pacman.getPosY();
        
        class Trad extends Thread {
            double  pacPosX, pacPosY;
            volatile boolean maalX, maalY;
            static volatile int n = 0;
            static volatile int id;
            Trad(double pacPosX, double pacPosY) {
                this.pacPosX = pacPosX;
                this.pacPosY = pacPosY;
                id = n++;
            }
            
            public void run() {
                volatile boolean harEndret = false;
                if(xpos < this.pacPosX && !maalX) {
                    xpos++;
                    break;
                }
                //legg til tilsvarende i else-ifs for x2, y1, y2
                
                if(!harEndret) {
                    final int SLEEP_TIME = 100;//endre til det du vil ha
                    try{
                        Thread.getCurrentThread().sleep(SLEEP_TIME);
                        run();
                    }catch(Exception e) {
                        //hva vil du?
                    }
                }
            }
        }
         Trad trad1 = new Trad(pacPosX, pacPosY);
        trad1.start();

        try {
            trad1.join(); //metoden vil vente her til posisjonene er like
        }catch(Exception e) {

        }
    }
    
}

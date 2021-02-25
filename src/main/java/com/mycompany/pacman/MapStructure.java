/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sveni
 */
public class MapStructure {
    public static final String NEW_LINE = "NL";
    public static final String FILE_PATH = "default-map";
    private String[] mapStructure;
    
    /**
     * default MapStructure
     */
    public MapStructure(){
      mapStructure = readFile(FILE_PATH);  
    }
    
    public String[] getMap(){
        return mapStructure;
    }
    
    public void genrateNewMap(){
        throw new NoSuchMethodError("Not suported jet");
    }
    
    
    
    /**
     *
     * @param path er filepath til kartfile
     * @return string[] som innerholder data struktur
     */
    protected final String[] readFile(String path){
        ArrayList<String> al = new ArrayList<>();
        try {
            File file = new File("default-map");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                if(scanner.hasNext(",")){
                    scanner.next();
                }
                // legger til new line i datastrukturen
                if(scanner.hasNextLine()){
                    al.add(NEW_LINE);
                }
                al.add(scanner.next());
            }
        }catch(FileNotFoundException e){}
        return (String[])al.toArray();
    }
}

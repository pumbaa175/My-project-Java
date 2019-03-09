/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.processed;

import com.example.data.Player;
import com.example.userinterface.TablePosition;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pumba
 */
public class BOTProcessed {
    
    private final int TYPE_RANDOM = 111;
    private final int TYPE_FIRE_1 = 222;
    
    private ArrayList<Player> alPlane;
    private ArrayList<Player> alFirePlane;
    private int countColumn = TablePosition.COUNT_COLUMN;
    private int typeFire = TYPE_RANDOM;
    private boolean isFire = false;
    private int selectColumn = 5;
    private int selectRow = 5;
    
    public BOTProcessed() {
        
    }
    
    public void choosePlane(){
        Random random = new Random();
        alPlane = new ArrayList<>();
        int cell;
        while(alPlane.size() < 5){
            int column = random.nextInt(10) + 1; //1-10
            int row = random.nextInt(10); //0-9
            cell = row *(countColumn - 1) + column;
            for(int i = 0; i < alPlane.size(); i++){
                if (cell == alPlane.get(i).getCell()){
                    continue;
                }
            }
            alPlane.add(new Player(column, row, countColumn));
        }
        
    }

    public void firePlane(){
        switch(typeFire){
            case TYPE_RANDOM:
                while(!firePlaneRandom()){}
                break;
            case TYPE_FIRE_1:
                while(!firePlaneNo1EasyMode(selectColumn, selectRow));
                break;
        }
        
    }
    
    private boolean firePlaneRandom(){
        Random random = new Random();
        int column = random.nextInt(8) + 2;  //2-9
        int row = random.nextInt(8) + 1; //1-8
        //Checking
        if(!checkDuplicate(column, row)){
            alFirePlane.add(new Player(column, row, countColumn));
            return true;
        }
        return false;
    }
    
    private boolean firePlaneNo1EasyMode(int selectColumn, int selectRow){
        Random random = new Random();
        int column = random.nextInt(3) + selectColumn - 1; //player.getcolumn - 1 ---> player.getcolumn +1
        int row = random.nextInt(3) + selectRow - 1; //player.getrow - 1 ---> player.getrow +1
        if(!checkDuplicate(column, row)){
            alFirePlane.add(new Player(column, row, countColumn));
            return true;
        }
        return false;
    }
    
    private boolean checkFireType(){
        
        return false;
    }
    
    private boolean checkDuplicate(int column, int row){
        int cell = row *(countColumn - 1) + column;
        for(Player p : alPlane){
            if (cell == p.getCell()){
                return true;
            }
        }
        for(Player p : alFirePlane){
            if(cell == p.getCell()){
                return true;
            }
        }
        return false;
    }
}

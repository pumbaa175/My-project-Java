/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.processed;

import com.example.data.Player;
import com.example.data.Position;
import com.example.userinterface.TablePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author pumba
 */
public class Processed {

    private TablePosition tablePosition;
    private BOTProcessed botProcessed;
    private HashMap<String, Player> hsYourPlane;
    private HashMap<String, Player> hsEnemyPlane;
    private ArrayList<Player> alYourFirePlane;
    private ArrayList<Player> alEnemyFirePlane;
    
    private int countCol = TablePosition.COUNT_COLUMN;

    public Processed() {
    }

    public Processed(TablePosition tablePosition, 
            HashMap<String, Player> hsYourPlane, 
            HashMap<String, Player> hsEnemyPlane, 
            ArrayList<Player> alYourFirePlane, 
            ArrayList<Player> alEnemyFirePlane) {
        this.tablePosition = tablePosition;
        this.hsYourPlane = hsYourPlane;
        this.hsEnemyPlane = hsEnemyPlane;
        this.alYourFirePlane = alYourFirePlane;
        this.alEnemyFirePlane = alEnemyFirePlane;
        botProcessed = new BOTProcessed(tablePosition, hsEnemyPlane, alEnemyFirePlane);
    }

    public HashMap<String, Player> getHsYourPlane() {
        return hsYourPlane;
    }

    public HashMap<String, Player> getAlEnemyPlane() {
        return hsEnemyPlane;
    }

    public ArrayList<Player> getAlYourFirePlane() {
        return alYourFirePlane;
    }

    public ArrayList<Player> getAlEnemyFirePlane() {
        return alEnemyFirePlane;
    }

    public BOTProcessed getBotProcessed() {
        return botProcessed;
    }
    

    public boolean hintsLog(Player firePlane, HashMap<String, Player> hsPlane) {
        if(hintsLogNo2(firePlane, hsPlane)){
            System.out.println("Plane is Dead");
            return true;
        }
        if(hintsLogNo1(firePlane, hsPlane)){
            System.out.println("Enermy Plane stay in area 3x3");
            return true;
        }
        return false;
    }


    
    //Plane in area 3x3
    private boolean hintsLogNo1(Player firePlayer, HashMap<String, Player> hsPlane){
        Iterator iterator = hsPlane.entrySet().iterator();
        while(iterator.hasNext()){
            Player player = (Player) iterator.next();
            if(firePlayer.getColumn() - 1 <= player.getColumn() && player.getColumn() <= firePlayer.getColumn() + 1){
                if(firePlayer.getRow()- 1 <= player.getRow()&& player.getRow() <= firePlayer.getRow()+ 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Fire to position Plane, Plane is Dead
    private boolean hintsLogNo2(Player firePlayer, HashMap<String, Player> hsPlane){
        Iterator iterator = hsPlane.entrySet().iterator();
        while(iterator.hasNext()){
            Player player = (Player) iterator.next();
            if(firePlayer.getCell() == player.getCell()){
               return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    //    private boolean hintsLogNo1(int fireCell, int[] plane) {
//        for (int i : plane) {
//            if ((fireCell - countCol < i) && (i < fireCell + countCol)) {
//                if (fireCell == (i + 1) || fireCell == (i - 1)) {
//                    return true;
//                }
//                if (fireCell == (i - countCol + 1) || fireCell == (i - countCol) || fireCell == (i - countCol + 2)) {
//                    return true;
//                }
//                if (fireCell == (i + countCol - 1) || fireCell == (i + countCol - 2) || fireCell == (i + countCol)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}

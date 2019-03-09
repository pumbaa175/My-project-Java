/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.data;

import java.util.HashMap;

/**
 *
 * @author pumba
 */
public class FirePlane {
    
    private HashMap<String, Position> myFirePlane;
    private HashMap<String, Position> enemyFirePlane;

    public FirePlane(HashMap<String, Position> myFirePlane, HashMap<String, Position> enemyFirePlane) {
        this.myFirePlane = myFirePlane;
        this.enemyFirePlane = enemyFirePlane;
    }

    public HashMap<String, Position> getMyFirePlane() {
        return myFirePlane;
    }

    public HashMap<String, Position> getEnemyFirePlane() {
        return enemyFirePlane;
    }
    
    
}

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
public class Plane {
    
    private HashMap<String, Position> myPlane;
    private HashMap<String, Position> enemyPlane;

    public Plane(HashMap<String, Position> myPlane, HashMap<String, Position> enemyPlane) {
        this.myPlane = myPlane;
        this.enemyPlane = enemyPlane;
    }

    public HashMap<String, Position> getMyPlane() {
        return myPlane;
    }

    public HashMap<String, Position> getEnemyPlane() {
        return enemyPlane;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.data;

/**
 *
 * @author pumba
 */
public class Position {
    
    private int column = 0;
    private int row = 0;
    private int cell = 0;

    public Position(int column, int row, int countColumn) {
        this.column = column;
        this.row = row;
        cell = (row) * (countColumn - 1) + column; //countColumn = 10 = (11 -1) 
    }

    public int getCell() {
        return cell;
    }
    
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.processed;

import com.example.data.Player;
import com.example.userinterface.TablePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JTable;

/**
 *
 * @author pumba
 */
public class BOTProcessed {

    private final int TYPE_RANDOM = 111;
    private final int TYPE_FIRE_1 = 222;
    private final String ENEMY_CHECK = "O";
    private final String ENEMY_PLANE = "EPLE";

    private TablePosition tablePosition;
    private HashMap<String, Player> hsPlane;
    private ArrayList<Player> alFirePlane;
    private ArrayList<Player> alNotPlane;
    private int countColumn = TablePosition.COUNT_COLUMN;
    private int typeFire = TYPE_RANDOM;
    private boolean isFire = false;
    private int selectColumn = 5;
    private int selectRow = 5;
    private int stepFirePlane = 0;
    private boolean blStepFirePlane = false;

    public BOTProcessed(TablePosition tablePosition, HashMap<String, Player> hsPlane, ArrayList<Player> alFirePlane) {
        this.tablePosition = tablePosition;
        this.hsPlane = hsPlane;
        this.alFirePlane = alFirePlane;
        alNotPlane = new ArrayList<>();
//        choosePlane(this.tablePosit ,this.hsPlane);

    }

    public void choosePlane(JTable tbPlane, HashMap<String, Player> hsPlane) {
        Random random = new Random();
        boolean duplicate = false;
        int cell;
        int i = 1;
        int column = random.nextInt(10) + 1; //1-10
        int row = random.nextInt(10); //0-9
        hsPlane.put(new Integer(1).toString(), new Player(column, row, countColumn));
        tbPlane.setValueAt(ENEMY_PLANE, row, column);
        while (hsPlane.size() < 5) {
            Iterator iterator = hsPlane.entrySet().iterator();
//            Iterator<Player> iterator = hsPlane.entrySet().iterator();
            column = random.nextInt(10) + 1; //1-10
            row = random.nextInt(10); //0-9
            cell = row * (countColumn - 1) + column;
            while (iterator.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) iterator.next();
                Player player = (Player) pair.getValue();
//                System.out.println(cell);
//                System.out.println(player.getCell());
                if (cell == player.getCell()) {
                    duplicate = true;
                    continue;
                }
            }
            if (!duplicate) {
                i++;
                hsPlane.put(new Integer(i).toString(), new Player(column, row, countColumn));
                tbPlane.setValueAt(ENEMY_PLANE, row, column);
            }
        }

    }

    public void firePlane(JTable tbPlane, boolean yourTurn) {
        if (!yourTurn) {
            switch (typeFire) {
                case TYPE_RANDOM:
                    while (!firePlaneRandom(tbPlane)) {
                    }
                    break;
//                case TYPE_FIRE_1:
//                    while (!firePlaneNo1Random(selectColumn, selectRow));
//                    break;
            }
        }
    }

    private boolean firePlaneRandom(JTable tbPlane) {
        Random random = new Random();
        int column = random.nextInt(8) + 2;  //2-9
        int row = random.nextInt(8) + 1; //1-8
        //Checking
        if (!checkDuplicate(column, row)) {
            alFirePlane.add(new Player(column, row, countColumn));
            tbPlane.setValueAt(ENEMY_CHECK, row, column);
            tablePosition.yourTurn = true;
            return true;
        }
        return false;
    }

    private boolean firePlaneNo1Random(int selectColumn, int selectRow) {
        Random random = new Random();
        int column = random.nextInt(3) + selectColumn - 1; //player.getcolumn - 1 ---> player.getcolumn +1
        int row = random.nextInt(3) + selectRow - 1; //player.getrow - 1 ---> player.getrow +1
        if (!checkDuplicate(column, row)) {
            alFirePlane.add(new Player(column, row, countColumn));
            return true;
        }
        return false;
    }

    private void firePlaneNo1(Player player) {
        Random random = new Random();
        int column = player.getColumn();
        int row = player.getRow();
        switch (stepFirePlane) {
            case 0:
                if (!checkDuplicate(column + 1, row)) {
                    alFirePlane.add(new Player(column, row, countColumn));
                    stepFirePlane = 1;
                }
                break;
            case 1:
                //true when fire have hints
                //It's ok.
                blStepFirePlane = random.nextBoolean();
                //plane is right 1,2,3,4 is postion of plane
                if (checkFireType()) {
                    if (checkDuplicate(column, row - 1)) {
                        if (!checkDuplicate(column, row + 1)) {
                            alFirePlane.add(new Player(column, row - 1, countColumn));
                            stepFirePlane = 21;//Postion 4; 2 is fire
                        } else if (checkDuplicate(column - 1, row + 1)) {
                            if (!checkDuplicate(column - 1, row - 1)) {
                                alFirePlane.add(new Player(column - 1, row - 1, countColumn));
                                stepFirePlane = 28;//Position 3; 1,2,4 is fire
                            } else {
                                stepFirePlane = 99;//1,2,3,4 is fire
                                break;
                            }
                        } else if (checkDuplicate(column - 1, row - 1)) {
                            alFirePlane.add(new Player(column - 1, row + 1, countColumn));
                            stepFirePlane = 28;//Position 1; 2,3,4 is fire
                        } else if (blStepFirePlane) {
                            alFirePlane.add(new Player(column - 1, row + 1, countColumn));
                            stepFirePlane = 29;//random 1 vs 3 --> select 1; 2,4 is fire
                        } else {
                            alFirePlane.add(new Player(column - 1, row - 1, countColumn));
                            stepFirePlane = 29;//random 1 vs 3 --> select 3; 2,4 is fire
                        }
                    } else if (checkDuplicate(column, row + 1)) {
                        alFirePlane.add(new Player(column, row - 1, countColumn));
                        stepFirePlane = 22;//Postion 2; 4 is fire
                    } else if (blStepFirePlane) {
                        alFirePlane.add(new Player(column, row + 1, countColumn));
                        stepFirePlane = 23;//Random 2 vs 4 --> select 2
                    } else {
                        alFirePlane.add(new Player(column, row - 1, countColumn));
                        stepFirePlane = 23;//Random 2 vs 4 --> select 4
                    }
                    //plane is left 1,2,3,4 not postion of plane
                    //5,6,7 is postion of plane
                } else {
                    if (checkDuplicate(column - 2, row - 1)) {
                        if (!checkDuplicate(column - 2, row + 1)) {
                            alFirePlane.add(new Player(column - 2, row + 1, countColumn));
                            stepFirePlane = 24;//Position 5; 7 is fire
                        } else {
                            alFirePlane.add(new Player(column - 2, row, countColumn));
                            stepFirePlane = 24;//Position 6; 5,7 is fire
                        }
                    } else if (checkDuplicate(column - 2, row + 1)) {
                        alFirePlane.add(new Player(column - 2, row - 1, countColumn));
                        stepFirePlane = 24;//Position 7; 5 is fire
                    } else if (blStepFirePlane) {
                        alFirePlane.add(new Player(column - 2, row + 1, countColumn));
                        stepFirePlane = 24;//Random 5 vs 7 --> select 5
                    } else {
                        alFirePlane.add(new Player(column - 2, row - 1, countColumn));
                        stepFirePlane = 24;//Random 5 vs 7 --> select 7
                    }
                }
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
            case 24:
                break;
        }
    }

    private boolean checkFireType() {

//        addPositionNotPlane(column, row);
        return false;
    }

    private void addPositionNotPlane(int column, int row) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                alNotPlane.add(new Player(column - 1 + j, row - 1 + i, countColumn));
            }
        }
    }

    private boolean checkDuplicate(int column, int row) {
        int cell = row * (countColumn - 1) + column;
        Iterator iterator = hsPlane.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) iterator.next();
            Player player = (Player) pair.getValue();
            if (cell == player.getCell()) {
                return true;
            }
        }
        for (Player p : alFirePlane) {
            if (cell == p.getCell()) {
                return true;
            }
        }
//        for (Player p : alNotPlane) {
//            if (cell == p.getCell()) {
//                return true;
//            }
//        }
        return false;
    }
}

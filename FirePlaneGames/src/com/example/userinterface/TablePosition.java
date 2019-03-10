/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userinterface;

import com.example.data.Player;
import com.example.processed.Processed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author pumba
 */
public class TablePosition extends javax.swing.JFrame {

    /**
     * Creates new form TablePosition
     */
    private final int TYPE_PLAYER_CHOOSE = 111;
    private final int TYPE_PLAYER_FIRE = 222;
    private final int NUMBER_PLANE = 5;
    public final static int COUNT_COLUMN = 11;
    private final String IS_CHECKED = "X";
    private final String IS_PLANE = "PLE";
    private final String YOUR_TURN_TXT = "Player turn : Your turn!";
    private final String ENEMY_TURN_TXT = "Player turn : Enemy turn!";

    private Processed processed;
    private int numberPlane = NUMBER_PLANE;
    private int typePlayer;
    private HashMap<String, Player> hsYourPlane;
    private HashMap<String, Player> hsEnemyPlane;
    private ArrayList<Player> alYourFirePlane;
    private ArrayList<Player> alEnemyFirePlane;
    private String[] stPlane;

    public boolean yourTurn = true;

    public TablePosition() {
        initComponents();
        addPlayer();
        addPlaneName();
        processed = new Processed(this, hsYourPlane, hsEnemyPlane, alYourFirePlane, alEnemyFirePlane);
        processed.getBotProcessed().choosePlane(tbPlane, hsEnemyPlane);
    }

    private void addPlayer() {
        hsYourPlane = new HashMap<>();
        hsEnemyPlane = new HashMap<>();
        alYourFirePlane = new ArrayList<>();
        alEnemyFirePlane = new ArrayList<>();
    }

    private void addPlaneName() {
        stPlane = new String[NUMBER_PLANE];
        for (int i = 0; i < stPlane.length; i++) {
            stPlane[i] = "Plane No." + (i + 1);
            hsYourPlane.put(stPlane[i], new Player(0, 0, 0));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPlane = new javax.swing.JTable();
        btNewGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbNumberMyPlane = new javax.swing.JLabel();
        lbNumberEnemyPlane = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taHintsLog = new javax.swing.JTextArea();
        btSelectOK = new javax.swing.JButton();
        lbPlayerTurn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbPlane.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", " ", " ", " ", " ", null, null, null, null, null, null},
                {"2", " ", " ", " ", null, null, null, null, null, null, null},
                {"3", " ", " ", " ", null, null, null, null, null, null, null},
                {"4", " ", " ", " ", null, null, null, null, null, null, null},
                {"5", " ", " ", " ", null, null, null, null, null, null, null},
                {"6", " ", " ", " ", null, null, null, null, null, null, null},
                {"7", " ", " ", " ", null, null, null, null, null, null, null},
                {"8", " ", " ", " ", null, null, null, null, null, null, null},
                {"9", " ", " ", " ", null, null, null, null, null, null, null},
                {"10", " ", " ", " ", null, null, null, null, null, null, null}
            },
            new String [] {
                "", "C1 ", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"
            }
        ));
        tbPlane.setRowHeight(30);
        tbPlane.setRowMargin(2);
        tbPlane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPlaneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPlane);

        btNewGame.setText("New Game");
        btNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewGameActionPerformed(evt);
            }
        });

        jLabel1.setText("Information :");

        lbNumberMyPlane.setText("My Plane: 5 Plane");

        lbNumberEnemyPlane.setText("Enemy Plane: 5 Plane");

        jLabel2.setText("Hints log:");

        taHintsLog.setColumns(20);
        taHintsLog.setLineWrap(true);
        taHintsLog.setRows(5);
        taHintsLog.setWrapStyleWord(true);
        taHintsLog.setEnabled(false);
        jScrollPane2.setViewportView(taHintsLog);

        btSelectOK.setText("OK");
        btSelectOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectOKActionPerformed(evt);
            }
        });

        lbPlayerTurn.setText("Player turn: ");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumberMyPlane)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btSelectOK)
                                    .addComponent(jLabel1))
                                .addGap(27, 27, 27)
                                .addComponent(btNewGame))
                            .addComponent(lbPlayerTurn)
                            .addComponent(lbNumberEnemyPlane))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSelectOK, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPlayerTurn)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbNumberMyPlane)
                        .addGap(18, 18, 18)
                        .addComponent(lbNumberEnemyPlane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPlaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPlaneMouseClicked
        //Insert string "X" to cell is Selected
        if (yourTurn) {
            int column = tbPlane.columnAtPoint(evt.getPoint());
            int row = tbPlane.rowAtPoint(evt.getPoint());
            chooseCell(column, row, typePlayer);
        }
        
    }//GEN-LAST:event_tbPlaneMouseClicked

    //Set value for Cell "X" vs "PLE"
    private void chooseCell(int column, int row, int typePlayer) {
        switch (typePlayer) {
            case TYPE_PLAYER_CHOOSE:
                if (changeCell(column, row)) {
                    if (tbPlane.getValueAt(row, column) == IS_PLANE) {
                        numberPlane++;
                        tbPlane.setValueAt("", row, column);
                        deletePlane(column, row);
                    } else {
                        if (numberPlane <= 0) {
                            JOptionPane.showMessageDialog(null, "Please push OK to finish your choice, number of your plane is full");
                            numberPlane = 0;
                            break;
                        }
                        tbPlane.setValueAt(IS_PLANE, row, column);
                        selectPlane(column, row);
                        numberPlane--;
                    }
                }
                break;
            case TYPE_PLAYER_FIRE:
                if (yourTurn) {
                    if (changeCell(column, row)) {
                        tbPlane.setValueAt(IS_CHECKED, row, column);
                        yourTurn = false;
                        processed.getBotProcessed().firePlane(tbPlane ,yourTurn);
                    }else{
//                        chooseCell(column, row, typePlayer);//Worng in here
                    }
                }
                break;
        }
    }

    //Checking value in Cell, if eual Null or "" --> Cell = "X" --> True
    private boolean changeCell(int column, int row) {
        String[] st = {"X", "O", "PLE", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String st1 : st) {
            try {
                if (tbPlane.getValueAt(row, column).equals(st1)) {
                    return false;
                }
            } catch (NullPointerException e) {
                return true;
            }
        }
        return true;
    }

    //Select position of Plane, add to HashMap hsPlayer1
    private void selectPlane(int column, int row) {
        for (String st : stPlane) {
            if (hsYourPlane.get(st).getCell() == 0) {
                hsYourPlane.put(st, new Player(column, row, COUNT_COLUMN));
                break;
            }
        }
    }

    //Select position of Plane, delele from HashMap hsPlayer1
    private void deletePlane(int column, int row) {
        int cell = (row) * (COUNT_COLUMN - 1) + column;
        for (String st : hsYourPlane.keySet()) {
            if (hsYourPlane.get(st).getCell() == cell) {
                hsYourPlane.put(st, new Player(0, 0, 0));
                break;
            }
        }
    }

    private void btNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewGameActionPerformed
        numberPlane = NUMBER_PLANE;
        typePlayer = TYPE_PLAYER_CHOOSE;
        addPlaneName();
    }//GEN-LAST:event_btNewGameActionPerformed

    private void btSelectOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectOKActionPerformed
        if (numberPlane == 0) {
            typePlayer = TYPE_PLAYER_FIRE;
            lbPlayerTurn.setText(YOUR_TURN_TXT);
        }
    }//GEN-LAST:event_btSelectOKActionPerformed

    public void playerTurn(boolean yourTurn) {
        if (yourTurn) {
            lbPlayerTurn.setText(YOUR_TURN_TXT);
        } else {
            lbPlayerTurn.setText(ENEMY_TURN_TXT);
        }
    }

    //Select 10 Plane in first New Game
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TablePosition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablePosition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablePosition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablePosition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TablePosition.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(TablePosition.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(TablePosition.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {

                    Logger.getLogger(TablePosition.class.getName()).log(Level.SEVERE, null, ex);
                }
                new TablePosition().setVisible(true);
            }
        });
    }

    public JTable getTbPlane() {
        return tbPlane;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNewGame;
    private javax.swing.JButton btSelectOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbNumberEnemyPlane;
    private javax.swing.JLabel lbNumberMyPlane;
    private javax.swing.JLabel lbPlayerTurn;
    private javax.swing.JTextArea taHintsLog;
    private javax.swing.JTable tbPlane;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userinterface;

import com.example.managerproduct.Table;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author pumba
 */
public class MenuNo1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuNo1
     */
    MenuInterface menuInterface;
    String idTable;
    
    public MenuNo1(MenuInterface menuInterface) {
        initComponents();
        this.menuInterface = menuInterface;
        addIDTable();
    }
    
    private void addIDTable(){
        DefaultComboBoxModel model = new DefaultComboBoxModel(Table.ID_TABLE);
        cbIDTabel.setModel(model);
    }
    
    public void showTextArea(byte menuID){
        switch(menuID){
            case 1:
                menuInterface.getData().showProduct(taMenuNo1, (byte) 1, Table.ID_TABLE[0]);
                break;
            case 3:
                menuInterface.getData().showProduct(taMenuNo1, (byte) 3, "");
                break;
        }
    }

    public void showMenu(){
        jLabel1.setVisible(true);
        cbIDTabel.setVisible(true);
        btPayments.setVisible(true);
    }
    
    public void hideMenu(){
        jLabel1.setVisible(false);
        cbIDTabel.setVisible(false);
        btPayments.setVisible(false);
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
        taMenuNo1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cbIDTabel = new javax.swing.JComboBox<>();
        btPayments = new javax.swing.JButton();

        setTitle("MenuNo1");
        setPreferredSize(new java.awt.Dimension(500, 400));

        taMenuNo1.setColumns(20);
        taMenuNo1.setRows(5);
        jScrollPane1.setViewportView(taMenuNo1);

        jLabel1.setText("Select ID Table");

        cbIDTabel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIDTabelItemStateChanged(evt);
            }
        });

        btPayments.setText("Payments");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbIDTabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btPayments, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbIDTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbIDTabelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIDTabelItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED){
            System.out.println(idTable);
            idTable = evt.getItem().toString();
            menuInterface.getData().showProduct(taMenuNo1, (byte) 1, idTable);
        }
    }//GEN-LAST:event_cbIDTabelItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPayments;
    private javax.swing.JComboBox<String> cbIDTabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taMenuNo1;
    // End of variables declaration//GEN-END:variables
}

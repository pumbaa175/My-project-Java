/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userinterface;

import com.example.managerproduct.Menu;
import com.example.managerproduct.Product;
import com.example.managerproduct.Table;
import java.io.BufferedReader;
import javax.swing.JTextArea;

/**
 *
 * @author pumba
 */
public class Data {

    private final String[] stTableName;
    private Product product;
    private Table table;

    public Data() {
        stTableName = Table.ID_TABLE;
        table = new Table();
        product = new Product();
        createProduct();
        addProductTable(stTableName[0], "Orange Juice", 1);
        addProductTable(stTableName[1], "Apple Juice", 2);
        addProductTable(stTableName[2], "Coffee", 3);
        addProductTable(stTableName[3], "Coca Cola", 4);
        addProductTable(stTableName[4], "Seven up", 5);
    }

    private void createProduct() {
        product.addProduct("Orange Juice", 20000, 25);
        product.addProduct("Orange Juice", 20000, 20);
        product.addProduct("Apple Juice", 30000, 15);
        product.addProduct("Coffee", 15000, 100);
        product.addProduct("Coffee with Milk", 18000, 75);
        product.addProduct("Coca Cola", 15000, 50);
        product.addProduct("Seven up", 15000, 50);
    }

    public String[] getStTableName() {
        return stTableName;
    }

    public Product getProduct() {
        return product;
    }

    public Table getTable() {
        return table;
    }

    public void addProductTable(String idTable, String productName, int productQuantity) {
        table.addProduct(idTable, productName, productQuantity);
    }

    public void showProduct(JTextArea jTextArea, byte menuID, String tableName) {
        jTextArea.setText("");
        switch (menuID) {
            case 1:
                int totalPayTable = 0;
                
                jTextArea.append("Billing" + "\n");
                jTextArea.append("------------------------------" + "\n");
                for (int i = 0; i < table.getHsTable().get(tableName).getHsQuantity().size(); i++) {
                    String idTable = tableName;
                    String productName = table.getHsTable().get(idTable).getAlName().get(i);
//                    System.out.println(productName);
                    int productQuantity = table.getHsTable().get(idTable).getHsQuantity().get(productName);
                    int productPrice = product.getHsPrice().get(productName);
                    table.getHsTable().get(idTable).getHsPrice().put(productName, productPrice);
                    int productPay = productQuantity * productPrice;
                    totalPayTable += productPay;
                    jTextArea.append("Prodct name: " + productName + "\n");
                    jTextArea.append("Quantity: " + productQuantity + "\n");
                    jTextArea.append("Total pay: " + productPay + "\n");
                    jTextArea.append("------------------------------" + "\n");
                }
                jTextArea.append("Total :" + totalPayTable);
//			totalRevenue.addTotalRevenue(totalPayTable);
                break;
//		case 11:
//			int totalPayTakeAway = 0;
//			System.out.println("Billing");
//			for (int i = 0; i < Main.takeAway.getProductTakeAway().getAlName().size(); i++) {
//				String productName = Main.takeAway.getProductTakeAway().getAlName().get(i);
//				int productQuantity = Main.takeAway.getProductTakeAway().getHsQuantity().get(productName);
//				int productPrice = Main.product.getHsPrice().get(productName);
//				Main.takeAway.getProductTakeAway().getHsPrice().put(productName, productPrice);
//				int productPay = productQuantity * productPrice;
//				totalPayTakeAway += productPay;
//				System.out.println("Prodct name: " + productName);
//				System.out.println("Quantity: " + productQuantity);
//				System.out.println("Total pay: " + productPay);
//				System.out.println("------------------------------");
//			}
//			System.out.println("Total :" + totalPayTakeAway);
//			totalRevenue.addTotalRevenue(totalPayTakeAway);
//			break;
//		case 2:
//			for (int i = 0; i < Main.product.getHsPrice().size(); i++){
////				System.out.println("1. Product 1");
//				String name = Main.product.getAlName().get(i);
//				System.out.println((i+1) + ". " + name);		
//			}
//			break;
            case 3:
                for (int i = 0; i < product.getHsPrice().size(); i++) {
                    String name = product.getAlName().get(i);
                    int quantity = product.getHsQuantity().get(product.getAlName().get(i));
                    jTextArea.append((i + 1) + ". " + name + " - Quantity " + quantity + "\n");
                }
                break;
            case 4:
                for (int i = 0; i < product.getHsQuantity().size(); i++) {
                    String name = product.getAlName().get(i);
                    int price = product.getHsPrice().get(product.getAlName().get(i));
                    int quantity = product.getHsQuantity().get(product.getAlName().get(i));
                    jTextArea.append((i + 1) + ". " + name + " - Quantity " + quantity + " - " + price + " VND" + "\n");
                }
                break;
            default:
                break;
        }
    }

}

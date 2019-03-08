package com.example.managerproduct;

import java.util.ArrayList;
import java.util.HashMap;

public class Product {

    private String[] alName;
    private HashMap<String, Integer> hsPrice = new HashMap<>();
    private HashMap<String, Integer> hsQuantity = new HashMap<>();

    public Product() {
        
    }

    public HashMap<String, Integer> getHsPrice() {
        return hsPrice;
    }

    public void setHsPrice(HashMap<String, Integer> hsPrice) {
        this.hsPrice = hsPrice;
    }

    public HashMap<String, Integer> getHsQuantity() {
        return hsQuantity;
    }

    public void setHsQuantity(HashMap<String, Integer> hsQuantity) {
        this.hsQuantity = hsQuantity;
    }

    public String getAlName(byte index) {
        return alName[index];
    }

    public void setAlName(String[] alName) {
        this.alName = alName;
    }

    //Add product
    public void addProduct(String name, int price, int quantity) {
        hsPrice.put(name, price);
        hsQuantity.put(name, quantity);
        addProductName();
    }

    public void addProduct(String name, int quantity) {
        hsQuantity.put(name, quantity);
        addProductName();
    }

    //Delete product
    public void deleteProduct(String name) {
        hsPrice.remove(name);
        hsQuantity.remove(name);
        addProductName();
    }

    //Modify product
    public void modifyProduct(String name) {

    }
    
    private void addProductName(){
        alName = new String [hsQuantity.size()];
        int i = 0;
        for (String st : hsQuantity.keySet()){
            alName[i] = st;
            i++;
        }
    }
    
//    private void show(){
//        for (String st : alName){
//            System.out.println(st);
//        }
//    }
//
//    public static void main(String[] args) {
//        Product product = new Product();
//        product.addProduct("Coffee", 15000, 10);
//        product.addProduct("Milk", 10000, 15);
//        product.show();
//    }
}

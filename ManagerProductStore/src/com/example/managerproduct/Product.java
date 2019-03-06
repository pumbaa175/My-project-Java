package com.example.managerproduct;

import java.util.ArrayList;
import java.util.HashMap;

public class Product {

    private ArrayList<String> alName = new ArrayList<String>();
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

    public ArrayList<String> getAlName() {
        return alName;
    }

    public void setAlName(ArrayList<String> alName) {
        this.alName = alName;
    }

    //Add product
    public void addProduct(String name, int price, int quantity) {
        alName.add(name);
        hsPrice.put(name, price);
        hsQuantity.put(name, quantity);

    }

    public void addProduct(String name, int quantity) {
        alName.add(name);
        hsQuantity.put(name, quantity);

    }

    //Delete product
    public void deleteProduct(String name) {
        for (int i = 0; i < alName.size(); i++) {
            if (alName.get(i) == name) {
                alName.remove(i);
                break;
            }
        }
        hsPrice.remove(name);
        hsQuantity.remove(name);
    }

    //Modify product
    public void modifyProduct(String name) {

    }

//	public static void main (String [] args) {
//		Product product = new Product();
//		System.out.println(product.getHsPrice().get("product 1"));
//	}
}

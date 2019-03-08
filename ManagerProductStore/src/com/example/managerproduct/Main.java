package com.example.managerproduct;

import java.util.InputMismatchException;

public class Main {

	static Product product = new Product();
	static Table table = new Table();
	static TakeAway takeAway = new TakeAway();
	static int selectMenu = 0;
	
	public static void main (String[] args) {
		
		
		product.addProduct("product 1", 25000, 37);
		product.addProduct("product 2", 28000, 50);
		product.addProduct("product 3", 37000, 28);
		
		Selection selection = new Selection();
				
		Menu menu = new Menu();
		menu.menuStart();
		
		selectMenu = IOput.input();
		selection.yourChoice(selectMenu);
		
	}
}

/// MainMenu
class Selection{
	public void yourChoice(int selectMenu) {
		
		Selection selection = new Selection();
		SelectionMenuNo1 selectionMenuNo1 = new SelectionMenuNo1();
		SelectionMenuNo2 selectionMenuNo2 = new SelectionMenuNo2();
		SelectionMenuNo3 selectionMenuNo3 = new SelectionMenuNo3();
		SelectionMenuNo4 selectionMenuNo4 = new SelectionMenuNo4();
		Menu menu = new Menu();
		
		switch(selectMenu){
		case 1:
			menu.menuNo1();
			selectMenu = IOput.input();
			selectionMenuNo1.yourChoise(selectMenu);
			break;
		case 2: 
			menu.menuNo2();
			selectMenu = IOput.input();
			selectionMenuNo2.yourChoise(selectMenu);
			break;
		case 3:
			menu.menuNo3();
			selectMenu = IOput.input();
			selectionMenuNo3.yourChoise(selectMenu);
			break;
		case 4:
			menu.menuNo4();
			selectMenu = IOput.input();
			selectionMenuNo4.yourChoise(selectMenu);
			break;
		case 5:
			menu.menuNo5();
			selectMenu = IOput.input();
			if (selectMenu == 0) {
				menu.menuMain();
				selectMenu = IOput.input();
				selection.yourChoice(selectMenu);
			}
		default:
			IOput.output("Your choice is wrong!");
			IOput.output("Please choose option meunu again: ");
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;				
		}	
	}
}

// MenuPayments
class SelectionMenuNo1 {
	public void yourChoise(int selectMenu) {
		Selection selection = new Selection();
		Menu menu = new Menu();
		
		switch(selectMenu) {
		case 0:
			menu.menuMain();
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		case 1:
			for (int i = 0; i < Table.ID_TABLE.length; i++) {
				IOput.output(i + 1 + ". " + Table.ID_TABLE[i]);
			}
			IOput.output("Please input ID table");
			selectMenu = IOput.input();
			menu.menuBillingTable(selectMenu);
			break;
		case 2:
			selectMenu = 1;
			menu.menuBillingTakeAway(selectMenu);
			break;
		default:
			IOput.output("Your choice is wrong!");
			IOput.output("Please choose option meunu again: ");
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		}
	}
}

//Menu Select product
class SelectionMenuNo2{
	public void yourChoise (int selectMenu) {
		Selection selection = new Selection();
		SelectionMenuNo2 selectionMenuNo2 = new SelectionMenuNo2();
		Menu menu = new Menu();
		int idName;
		int productQuantity;
		switch (selectMenu) {
		case 0:
			menu.menuMain();
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		//Select product for table
		case 1:
			menu.selectProductTable();
			IOput.output("Plese input ID table :");
			selectMenu = IOput.input();
			IOput.output("Plese input product's name :");
			idName = IOput.input();
			IOput.output("Plese input product's quantity :");
			productQuantity = IOput.input();
//			Main.table.addProduct(Table.ID_TABLE[selectMenu-1], Main.product.getAlName().get(idName-1), productQuantity);
			menu.menuSelectProduct();
			selectMenu = IOput.input();
			selectionMenuNo2.yourChoise(selectMenu);
			break;
		//Select product for take away
		case 2:
			menu.selectProductTakeAway();
			IOput.output("Plese input product's name :");
			idName = IOput.input();
			IOput.output("Plese input product's quantity :");
			productQuantity = IOput.input();
//			Main.takeAway.addProduct(Main.product.getAlName().get(idName-1), productQuantity);
			menu.menuSelectProduct();
			selectMenu = IOput.input();
			selectionMenuNo2.yourChoise(selectMenu);
			break;
		}
	}
}

//Menu Checking product
class SelectionMenuNo3 {
	public void yourChoise (int selectMenu) {
		Selection selection = new Selection();
		Menu menu = new Menu();
		
		switch(selectMenu) {
		case 0:
			menu.menuMain();
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		default:
			IOput.output("Your choice is wrong!");
			IOput.output("Please choose option meunu again: ");
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		}
	}
}

//MenuInput product
class SelectionMenuNo4 {
	public void yourChoise (int selectMenu) {
		Selection selection = new Selection();
		SelectionMenuNo4 selectionMenuNo4 = new SelectionMenuNo4();
		Menu menu = new Menu();
		
		switch(selectMenu){
		case 1:
			menu.menuInputAdd();
			try {
				String name = IOput.inputString();
				if (name.equals("0")) {
					menu.menuNo4();
					selectMenu = IOput.input();
					selectionMenuNo4.yourChoise(selectMenu);
					break;
				}
				int price = 0; 
				IOput.output("Please input product's price :");
				price = IOput.input();
				int quantity = 0;
				IOput.output("Please input product's quantity :");
				quantity = IOput.input();
				if (name != null && price != 0 && quantity != 0) {
//					System.out.println("It is ok");
					Main.product.addProduct(name, price, quantity);
				}
				menu.menuNo4();
				selectMenu = IOput.input();
				selectionMenuNo4.yourChoise(selectMenu);
				break;
			} 
			catch (InputMismatchException e) {
				IOput.output("Please select agian, you input wrong!");
				menu.menuNo4();
				selectMenu = IOput.input();
				selectionMenuNo4.yourChoise(selectMenu);
				break;
			}
		case 2: 
			menu.menuInputModify();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
                    // TODO Auto-generated catch block
			}
			menu.menuMain();
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		case 3:
			menu.menuInputRemove();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
                    // TODO Auto-generated catch block
			}
			menu.menuMain();
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		case 0:
			menu.menuMain();
			selectMenu = IOput.input();
			selection.yourChoice(selectMenu);
			break;
		default:
			IOput.output("Your choice is wrong!");
			IOput.output("Please choose option meunu again: ");
			selectMenu = IOput.input();
			selectionMenuNo4.yourChoise(selectMenu);
			break;				
		}	
	}
}







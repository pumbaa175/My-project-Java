package com.example.managerproduct;

public class Menu {
	
	TotalRevenue totalRevenue = new TotalRevenue();
	private int selectMenu = 0;
	
	public void menuStart() {
		System.out.println("System is start . . .");
		System.out.println("Hello, system is ready");
		menuMain();
	}
	public void menuMain() {
		System.out.println("Plesse select you choose in menu");
		System.out.println("1. Payments");
		System.out.println("2. Select product for Customer");
		System.out.println("3. Checking product in Store");
		System.out.println("4. Input product for manager");
		System.out.println("5. Total Revenue");
	}
	public void menuNo1() {
		menuPayments();
		
	}
	public void menuNo2() {
		menuSelectProduct();	
	}
	public void menuNo3() {
		menuCheckingProduct();
	}
	public void menuNo4() {
		menuInputProduct();
	}
	
	public void menuNo5() {
		menuTotalRevenue();
	}
	
	public void menuPayments() {
		System.out.println("Press 0 to back from Menu");
		System.out.println("Press 1 to select payments for table");
		System.out.println("Press 2 to select payments for take away");
		
	}
	
	public void menuBillingTable(int selectMenu) {
		this.selectMenu = selectMenu;
		showProduct((byte) 1);
	}
	
	public void menuBillingTakeAway(int selectMenu) {
		this.selectMenu = selectMenu;
		showProduct((byte) 11);
	}
	
	public void menuSelectProduct() {
		System.out.println("Press 0 to back from Menu");
		System.out.println("Press 1 to select product for Table");
		System.out.println("Press 2 to select product for take away");
	}
	
	public void selectProductTable() {
		System.out.println("Plesse select you choose product");
		for (int i = 0; i < Table.idTable.length; i++) {
			IOput.output(i + 1 + ". " + Table.idTable[i]);
		}
		IOput.output("-----------------------------------------");
		showProduct((byte) 2);
	}
	
	public void selectProductTakeAway() {
		System.out.println("Plesse select you choose product");
		//show product with menu = 2
		showProduct((byte) 2);
	}
	
	public void menuInputQuantity() {
		System.out.println("Press 0 to cancel select and back from Menu Product");
		System.out.println("------------------------------");
		System.out.println("Your Product is " + Main.product.getAlName().get(Main.selectMenu - 1));
		System.out.println("Plesse input quantity of product");
		System.out.println("Quantity of Product = ");
	}
	
	public void menuCheckingProduct() {
		System.out.println("Press 0 to back from Menu");
		System.out.println("Product in Store:");
		showProduct((byte) 3);
	}
	
	public void menuInputProduct() {
		System.out.println("Press 0 to back from Menu");
		System.out.println("Press 1 to Add Product");
		System.out.println("Press 2 to Modify Product");
		System.out.println("Press 3 to Remove Product");
		System.out.println("Product in Store:");
		showProduct((byte) 4);
	}
	
	public void menuInputAdd() {
		System.out.println("Press 0 to back from MenuInputProduct");
		System.out.println("Please input product's name: ");
	}
	
	
	
	public void menuInputModify() {
		System.out.println("Press 0 to back from MenuInputProduct");
		System.out.println("Please");
	}
	
	public void menuInputRemove() {
		System.out.println("Press 0 to back from MenuInputProduct");
		System.out.println("Remove Product");
	}
	
	public void menuTotalRevenue() {
		System.out.println("Press 0 to back from Menu");
		IOput.output("Total Revenue in Store: ");
		IOput.output(totalRevenue.getTotalRevenue() + "");
	}
	
	public void showProduct(byte menu) {
		switch (menu) {
		case 1:
			int totalPayTable = 0;
			System.out.println("Billing");
			for (int i = 0; i < Main.table.getHsTable().get(Table.idTable[selectMenu-1]).getAlName().size(); i++) {
				String idTable = Table.idTable[selectMenu-1];
				String productName = Main.table.getHsTable().get(idTable).getAlName().get(i);
				int productQuantity = Main.table.getHsTable().get(idTable).getHsQuantity().get(productName);
				int productPrice = Main.product.getHsPrice().get(productName);
				Main.table.getHsTable().get(idTable).getHsPrice().put(productName, productPrice);
				int productPay = productQuantity * productPrice;
				totalPayTable += productPay;
				System.out.println("Prodct name: " + productName);
				System.out.println("Quantity: " + productQuantity);
				System.out.println("Total pay: " + productPay);
				System.out.println("------------------------------");
			}
			System.out.println("Total :" + totalPayTable);
			totalRevenue.addTotalRevenue(totalPayTable);
			break;
		case 11:
			int totalPayTakeAway = 0;
			System.out.println("Billing");
			for (int i = 0; i < Main.takeAway.getProductTakeAway().getAlName().size(); i++) {
				String productName = Main.takeAway.getProductTakeAway().getAlName().get(i);
				int productQuantity = Main.takeAway.getProductTakeAway().getHsQuantity().get(productName);
				int productPrice = Main.product.getHsPrice().get(productName);
				Main.takeAway.getProductTakeAway().getHsPrice().put(productName, productPrice);
				int productPay = productQuantity * productPrice;
				totalPayTakeAway += productPay;
				System.out.println("Prodct name: " + productName);
				System.out.println("Quantity: " + productQuantity);
				System.out.println("Total pay: " + productPay);
				System.out.println("------------------------------");
			}
			System.out.println("Total :" + totalPayTakeAway);
			totalRevenue.addTotalRevenue(totalPayTakeAway);
			break;
		case 2:
			for (int i = 0; i < Main.product.getHsPrice().size(); i++){
//				System.out.println("1. Product 1");
				String name = Main.product.getAlName().get(i);
				System.out.println((i+1) + ". " + name);		
			}
			break;
		case 3:
//			System.out.println("1. Product 1 - Quantity 50");
			for (int i = 0; i < Main.product.getHsPrice().size(); i++){
				String name = Main.product.getAlName().get(i);
				int quantity = Main.product.getHsQuantity().get(Main.product.getAlName().get(i));
				System.out.println((i+1) + ". " + name + " - Quantity " +quantity);		
			}
			break;
		case 4:
//			System.out.println("1. Product 1 - Quantity 50 - Price 50 000 VND");
			for (int i = 0; i < Main.product.getHsPrice().size(); i++){
				String name = Main.product.getAlName().get(i);
				int price = Main.product.getHsPrice().get(Main.product.getAlName().get(i));
				int quantity = Main.product.getHsQuantity().get(Main.product.getAlName().get(i));
				System.out.println((i+1) + ". " + name + " - Quantity " + quantity + " - " + price + " VND");		
			}
			break;
		default:
			break;
		}
	}
}

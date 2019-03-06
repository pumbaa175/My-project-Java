package com.example.managerproduct;

import java.util.Scanner;

public class IOput {
	
	public static void main(String[] args) {
		
	}
	
	public static int input() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		return i;
	}
	public static String inputString() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		return string;
	}
	
	public static void output(String s) {
		System.out.println(s);
	}
}

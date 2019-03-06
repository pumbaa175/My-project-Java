package com.example.inout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	public static void main (String [] args) {
		
		System.out.println("Đây là Class Main");
		Input input = new Input();
		MyOutput output = new MyOutput((int) 85);
		
	}
}



class Input {
	
	String s;
	
	public Input () {
		Scanner input = new Scanner(System.in);
		System.out.println("Đây là Class Input");
		System.out.println("Nhập giá trị Integer là ");
		int numberInteger = input.nextInt();
		MyOutput output = new MyOutput(numberInteger);
		input = new Scanner (System.in);
		System.out.println("Nhập giá trị String là ");
		s = input.nextLine();
		output = new MyOutput(s);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Nhập String value: ");
			String s = br.readLine();
			System.out.println("Nhập Integer value");
			int i = Integer.parseInt(br.readLine());
			System.out.println("String : " + s);
			System.out.println("Integer : " + i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Bạn nhập sai định dạng của Integer");
		}
	}
}
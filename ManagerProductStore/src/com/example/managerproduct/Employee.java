package com.example.managerproduct;

public class Employee {
	
	private String[] name;
	private int [] salary;
	private int hour;
	
	public Employee(String[] name, int[] salary, int hour) {
		super();
		this.name = name;
		this.salary = salary;
		this.hour = hour;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public int[] getSalary() {
		return salary;
	}

	public void setSalary(int[] salary) {
		this.salary = salary;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int sumSalary() {
		int sumSalary = 0;
		return sumSalary;
	}
		
}

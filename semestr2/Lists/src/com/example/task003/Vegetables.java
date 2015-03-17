package com.example.task003;

public class Vegetables {
	public String name;
	public String sort;
	public int price;

	public Vegetables(String name, String sort, int price) {
		this.name = name;
		this.sort = sort;
		this.price = price;
	}
	public String getName(){
		return name;
	}
	public String getSort(){
		return sort;
	}
	public int getPrice(){
		return price;
	}
}

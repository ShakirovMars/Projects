package com.example.task003;

public class Main {
	public static void main(String[] args) {
		Board board = new Board(4, 3.2, "NVIDIA", 3, 500, 1200,"1024*980",12,15,"ios");
		Laptop laptop = new Laptop(4, 3.2, "NVIDIA", 3, 500, 1200,"1024*980",12,15);
		laptop.charge(100);
		System.out.println(laptop.getDiagonal());
	}
}
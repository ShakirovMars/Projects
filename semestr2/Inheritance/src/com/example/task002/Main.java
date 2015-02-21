package com.example.task002;

public class Main {
	public static void main(String[] args) {
		Monitor monitor =new Monitor("1024*980",3,4);
		monitor.getDiagonal();
		System.out.println(monitor.getDiagonal());
	}
}

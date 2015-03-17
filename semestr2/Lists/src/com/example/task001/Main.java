package com.example.task001;

public class Main {

	public static void main(String args[]) {
		Stack stack = new Stack();
		stack.add(4);
		stack.add(5);
		stack.add(-1);
		stack.add(8);
		
		System.out.println("max=" + stack.maximum());
		System.out.println("min=" + stack.minimum());
		System.out.println(stack.remove());
		System.out.println("max=" + stack.maximum());
	}
}

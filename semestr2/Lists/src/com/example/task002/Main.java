package com.example.task002;

public class Main {
	public static void main(String args[]) {
		Queue queue= new Queue();
		queue.add(4);
		queue.add(5);
		queue.add(1);
		queue.add(8);
		System.out.println("counOdd="+queue.countOdd());
        System.out.println(queue.remove());
     
	}
}

package com.example.task003;

public class Main {
	public static void main(String args[]) throws ArrayIndexOutOfBoundException {
		List list = new List();
		Vegetables vegetables = new Vegetables("apelsin", "sort1", 45);
		Vegetables vegetables1 = new Vegetables("banan", "sort2", 20);
		Vegetables vegetables2 = new Vegetables("arbus", "sort3", 485);
		Vegetables vegetables3 = new Vegetables("barange", "sort4", 85);
		list.addTop(vegetables);
		list.addEnd(vegetables1);

		list.addEnd(vegetables2);

		list.addTop(vegetables3);
		// list.removeBegin();
		// list.removeEnd();
		 list.show();
		list.search(1);

	}
}
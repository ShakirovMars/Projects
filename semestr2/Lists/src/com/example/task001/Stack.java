package com.example.task001;

public class Stack {
	public class Node {
		int number;
		Node next;
	}

	Node header;

	public void add(int number) {
		Node node = new Node();
		node.number = number;
		node.next = header;
		header = node;
	}

	public int remove() {
		int number = header.number;
		Node temp = header;
		header = header.next;
		temp.next = null;
		temp = null;
		return number;

	}

	public int maximum() {
		Node search = header;
		int max = 0;
		while (search != null) {
			if (search.number > max) {
				max = search.number;
			}
			search = search.next;
		}
		return max;
	}

	public int minimum() {
		Node search = header;
		int min = search.number;
		while (search != null) {
			if (search.number < min) {
				min = search.number;
			}
			search = search.next;
		}
		return min;
	}

}

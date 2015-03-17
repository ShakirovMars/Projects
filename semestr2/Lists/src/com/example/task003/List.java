package com.example.task003;

public class List {
	public class Node {
		Vegetables vegetables;
		Node next;
	}

	Node header;

	public void addTop(Vegetables vegetables) {
		Node node = new Node();
		node.vegetables = vegetables;
		node.next = header;
		header = node;
	}

	public void addEnd(Vegetables vegetables) {
		Node node = new Node();
		node.vegetables = vegetables;
		node.next = null;
		if (header != null) {
			Node temp;
			temp = header;
			while (temp.next != null) {
				temp = temp.next;

			}
			temp.next = node;
		} else {
			header = node;
		}
	}

	public void show() {
		Node temp;
		temp = header;
		while (temp != null) {

			System.out.println(temp.vegetables.getName());
			temp = temp.next;
		}
	}

	public Vegetables removeBegin() {
		Vegetables vegetables = header.vegetables;
		Node temp = header;
		header = header.next;
		temp.next = null;
		temp = null;
		return vegetables;
	}

	public Vegetables removeEnd() {
		Node temp = header;

		while (temp.next.next != null) {
			temp = temp.next;

		}
		Vegetables vegetables = temp.vegetables;

		temp.next = null;
		temp = null;

		return vegetables;

	}

	public Vegetables search(int x) throws ArrayIndexOutOfBoundException {
		int index = 0;
		int size = 0;
		Node temp;
		temp = header;
		while (temp != null) {
			temp = temp.next;
			size++;
			
		}

		temp = header;
		if (x < size) {
			if (header != null) {

				while (index != x) {
					temp = temp.next;
					index++;
				}

			} else {
				return null;
			}

			System.out.println(temp.vegetables.getName());
			return temp.vegetables;
		} else {
			throw new ArrayIndexOutOfBoundException();
		}

	}

}

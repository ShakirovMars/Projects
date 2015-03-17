package com.example.task002;

public class Queue {

	public class Node {
		int number;
		Node next;
	}

	Node header;

	public void add(int number) {
		Node node = new Node();
		node.number = number;
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

	public int remove() {
		int number = header.number;
		Node temp = header;
		header = header.next;
		temp.next = null;
		temp = null;
		return number;

	}
	public int countOdd(){
		Node temp;
		int count=0;
		temp=header;
		while (temp != null) {
			if(temp.number%2==0){
				count++;
			}
          temp=temp.next;
		}
		
		return count;
		
	}

}

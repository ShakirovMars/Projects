package Set;

public class Set {
	// Creation of an internal node class
	public class Node {
		int number;
		Node next;

	}

	// The variable for the top of the list
	Node header;

	// A method of adding
	public void add(int number) {
		if (!check(number)) {
			Node node = new Node();
			node.number = number;
			if (header == null) {
				node.next = null;
				header = node;
			} else {
				node.next = header;
				header = node;

			}
		} else {
			return;
		}
	}

	// Standard method of removal
	public int remove() {
		int number = header.number;
		Node temp = header;
		header = header.next;
		temp.next = null;
		return number;
	}

	// View items
	public void show() {
		Node temp;
		temp = header;
		while (temp != null) {
			System.out.println(temp.number);
			temp = temp.next;
		}
	}

	// Checking the existence of an element in the list
	public boolean check(int number) {
		boolean check = false;
		Node temp;
		temp = header;
		if (header != null) {

			while (temp != null && !check) {
				if (temp.number == number) {
					check = true;
				}
				temp = temp.next;
			}

		} else {
			check = false;
		}

		return check;
	}

	// Removal method by value
	public void delete(int number) {
		Node temp;
		temp = header;
		if (header == null) {
			return;
		} else {
			if (check(number)) {
				if (header.number != number) {
					while (temp != null) {
						if (temp.next.number == number
								&& temp.next.next != null) {
							Node current = temp.next;
							temp.next = temp.next.next;
							current.next = null;
							current = null;
							break;
						} else {
							if (temp.next.number == number
									&& temp.next.next == null) {
								temp.next = null;
								break;
							}
						}

						temp = temp.next;
					}

				}

				else {
					header = temp.next;
					temp.next = null;

				}
			} else {
				return;
			}
		}
	}

	// The method returns the number of elements and outputting the number of
	// missing elements
	public int completenessCheck() {
		Node temp;
		temp = header;
		int n = 0;
		int m = 0;
		while (temp != null) {
			n++;
			temp = temp.next;
		}
		m = 999999 - n;
		System.out.println("Necessary to complete the collection: " + m);
		return n;
	}

	// Method of finding the minimum element
	public int min() {
		int min = header.number;
		Node temp;
		temp = header;
		while (temp != null) {
			if (min > temp.number) {
				min = temp.number;
			}
			temp = temp.next;
		}
		return min;
	}

	// A method for checking the possibility of drawing up of the elements of a
	// given set of ordered sequence
	public boolean checkChain() {
		boolean check = true;
		boolean checkS = false;
		int number = min();
		int amt = completenessCheck() - 1;
		while (amt != 0 && check) {

			checkS = false;
			Node temp;
			temp = header;
			while (temp != null && !checkS) {
				if (temp.number == number + 1) {
					checkS = true;
					number = temp.number;
				}
				temp = temp.next;
			}
			check = checkS;
			amt--;

		}
		System.out.println(check);
		return check;
	}

}

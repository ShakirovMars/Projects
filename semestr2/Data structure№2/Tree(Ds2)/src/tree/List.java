package tree;

public class List<T> {
	public class Node {
		T value;;
		Node next;

	}

	Node header;

	// add node
	public void add(T value) {

		Node node = new Node();
		node.value = value;
		if (header == null) {
			node.next = null;
			header = node;
		} else {
			node.next = header;
			header = node;

		}

	}

	// removal node
	public void delete(T value) {
		Node temp;
		temp = header;
		if (header == null) {
			return;
		} else {
			if (check(value)) {
				if (header.value != value) {
					while (temp != null) {
						if (temp.next.value == value && temp.next.next != null) {
							Node current = temp.next;
							temp.next = temp.next.next;
							current.next = null;
							current = null;
							break;
						} else {
							if (temp.next.value == value
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
					temp = null;

				}
			} else {
				return;
			}
		}
	}

	// checking the existence of node
	public boolean check(T value) {
		boolean check = false;
		Node temp;
		temp = header;
		if (header != null) {

			while (temp != null && !check) {
				if (temp.value == value) {
					check = true;
				}
				temp = temp.next;
			}

		} else {
			check = false;
		}

		return check;
	}

}

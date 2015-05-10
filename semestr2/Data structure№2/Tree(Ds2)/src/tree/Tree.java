package tree;

public class Tree {
	public class Node {
		char letter;
		Node parent;
		List<Node> children;
		boolean positionEnd = false;
	}

	// auxiliary variable that remembers the last place of stay
	Node save;
	// tree root
	Node root;

	// the creation of a zero root
	public void creationRoot() {
		Node node = new Node();
		root = node;

	}

	// the method of adding the word
	public void addWord(String word) {
		char a;
		Node temp = root;
		for (int i = 0; i < word.length(); i++) {
			a = word.charAt(i);

			if (check(a, temp)) {
				// Moves on wood
				temp = save;
			} else {
				// create a list if it was not created earlier
				if (temp.children == null) {
					temp.children = new List<Node>();
				}
				addChar(a, temp);
				// Moves on wood
				temp = save;
			}
			// We mark the final letter
			if (i == word.length() - 1) {
				temp.positionEnd = true;
			}

		}

	}

	// method of checking character

	public boolean check(char a, Node temp) {
		boolean check = false;
		if (temp.children != null && temp.children.header != null) {
			List<Node>.Node current = temp.children.header;
			while (current != null && !check) {
				if (current.value.letter == a) {
					// remember the last place of residence
					save = current.value;
					check = true;
				}
				current = current.next;
			}

		}
		return check;
	}

	// a method of adding symbol
	public void addChar(char a, Node temp) {
		Node node = new Node();
		node.letter = a;
		// remember the last place of residence
		save = node;
		temp.children.add(node);
		node.parent = temp;

	}

	// method of verification word
	public boolean wordSearch(String word) {
		char a;
		boolean check = false;
		Node temp = root;
		for (int i = 0; i < word.length(); i++) {
			a = word.charAt(i);
			if (check(a, temp)) {
				temp = save;
				if ((i == word.length() - 1) && (temp.positionEnd == true)) {
					check = true;
				}
			} else {
				break;
			}

		}

		return check;
	}

	// method to remove words
	public void wordDelete(String word) {
		if (wordSearch(word)) {
			Node temp = save;

			if (temp.children == null || temp.children.header == null) {
				while (temp != null && temp.children == null
						|| temp.children.header == null) {

					temp.parent.children.delete(temp);
					temp = temp.parent;

					if (temp.positionEnd == true) {
						break;
					}
				}
			} else {
				temp.positionEnd = false;

			}

		}
	}

	// the method of adding text
	public void addText(String text) {
		// remove extra spaces at the beginning and end of the text
		String textE = text.trim();
		int j = 0;
		for (int i = 0; j < textE.length(); i = textE.indexOf(" ", i) + 1) {

			if (textE.indexOf(" ", i) != -1) {
				j = textE.indexOf(" ", i);
			} else {
				j = textE.length();
			}

			addWord(textE.substring(i, j));

		}
	}

}

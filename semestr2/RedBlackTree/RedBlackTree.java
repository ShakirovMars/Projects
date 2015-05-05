package RedBlackTree;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree {
	public class Node {
		int number;
		String color;
		Node left;
		Node right;
		Node parent;
	}

	Node save;
	Node root;

	public Node uncle(Node temp) {
		Node uncle = null;
		if (temp.parent != null && temp.parent.parent != null
				&& temp.parent.parent.left == temp.parent) {
			uncle = temp.parent.parent.right;
		} else {
			if (temp.parent != null && temp.parent.parent != null
					&& temp.parent.parent.right == temp.parent) {
				uncle = temp.parent.parent.left;
			}
		}
		return uncle;
	}

	public void redUncle(Node temp) {
		Node uncle = uncle(temp);
		uncle.color = "black";
		temp.parent.color = "black";
		temp.parent.parent.color = "red";
	}

	// отец нового узла является левым сыном своего отца и добавляемый элемент
	// слева
	public void method1(Node temp) {
		Node uncle = uncle(temp);
		if (uncle == null || uncle.color == "black") {
			temp.parent.color = "black";
			temp.parent.parent.color = "red";
			turnRight(temp.parent.parent);

		}
	}

	// отец нового узла является правым сыном своего отца и добавляемый элемент
	// слева
	public void method2(Node temp) {
		Node current = temp.parent;
		turnRight(current);
		current.parent.color = "black";
		current.parent.parent.color = "red";
		turnLeft(current.parent.parent);

	}

	// отец нового узла является левым сыном своего отца и добавляемый элемент
	// справа
	public void method3(Node temp) {
		Node current = temp.parent;
		turnLeft(current);
		current.parent.color = "black";
		current.parent.parent.color = "red";
		turnRight(current.parent.parent);
	}

	// отец нового узла является правым сыном своего отца и добавляемый элемент
	// справа
	public void method4(Node temp) {
		temp.parent.color = "black";
		temp.parent.parent.color = "red";
		turnLeft(temp.parent.parent);

	}

	public void balancing(Node temp) {
		if (temp.parent.color == "red") {
			Node uncle = uncle(temp);
			while (temp.parent != null && temp.parent.color != "black") {
				if (uncle != null && uncle.color == "red") {
					redUncle(temp);
				} else {
					if (temp.parent.parent != null
							&& temp.parent == temp.parent.parent.left
							&& temp == temp.parent.left) {
						method1(temp);
					} else {
						if (temp.parent.parent != null
								&& temp.parent == temp.parent.parent.left
								&& temp == temp.parent.right) {
							method3(temp);
						} else {
							if (temp.parent.parent != null
									&& temp.parent == temp.parent.parent.right
									&& temp == temp.parent.left) {
								method2(temp);
							} else {
								if (temp.parent.parent != null
										&& temp.parent == temp.parent.parent.right
										&& temp == temp.parent.right) {
									method4(temp);
								}

							}
						}
					}
				}
				if (temp.parent != null && temp.parent.parent != null) {
					temp = temp.parent.parent;
					uncle = uncle(temp);
				}
				if (temp.parent == null && temp.color == "red") {
					temp.color = "black";
					break;
				} else {
					if (temp.parent != null && temp.parent.parent == null
							&& temp.parent.color == "red") {
						temp.parent.color = "black";
						break;

					}

				}
			}

		}
	}

	public void addLeft(Node node1, int number) {

		Node node = new Node();
		node.number = number;
		node.color = "red";
		if (root != null) {
			node.parent = node1;
			node1.left = node;
			balancing(node);

		} else {
			root = node;
			node.color = "black";

		}
	}

	public void addRight(Node node1, int number) {

		Node node = new Node();
		node.number = number;
		node.color = "red";
		if (root != null) {
			node.parent = node1;
			node1.right = node;
			balancing(node);

		} else {
			root = node;
			node.color = "black";

		}

	}

	public void addToTheTree(int num) {
		Node temp = root;
		if (root != null) {
			while (temp.right != null || temp.left != null) {
				if (temp.number > num && temp.left != null) {
					temp = temp.left;
				} else {
					if (temp.number < num && temp.right != null) {
						temp = temp.right;
					} else {
						break;
					}
				}
			}

			if (temp.number > num) {
				addLeft(temp, num);

			} else {
				addRight(temp, num);

			}

		} else {
			addLeft(temp, num);

		}

	}

	public void turnRight(Node top) {

		if (top.parent != null) {
			if (top.parent.left == top) {
				top.parent.left = top.left;
			} else {
				top.parent.right = top.left;
			}
		}
		if (top == root) {
			root = top.left;
		}

		top = top.left;
		if (top.right != null) {
			top.right.parent = top.parent;
		}
		top.parent.left = top.right;
		top.right = top.parent;
		top.parent = top.right.parent;
		top.right.parent = top;

	}

	public void turnLeft(Node top) {

		if (top.parent != null) {
			if (top.parent.left == top) {
				top.parent.left = top.right;
			} else {
				top.parent.right = top.right;
			}
		}
		if (top == root) {
			root = top.right;
		}
		top = top.right;
		if (top.left != null) {
			top.left.parent = top.parent;
		}
		top.parent.right = top.left;
		top.left = top.parent;
		top.parent = top.left.parent;
		top.left.parent = top;

	}

	private void LKP(Node current) {
		if (current == null)
			return;
		LKP(current.left);
		System.out.print(current.number + " ");
		System.out.println(current.color);
		LKP(current.right);

	}

	public void showLKP() {
		LKP(root);
	}

	public void bypassingWide(Node top) {
		Queue<Node> queue = new LinkedList<>();
		System.out.print(root.number + " ");
		System.out.println(root.color);
		do {

			if (!queue.isEmpty()) {

				top = queue.poll();

				System.out.print(top.number + " ");
				System.out.println(top.color);
			}
			if (top.left != null) {
				queue.add(top.left);
			}
			if (top.right != null) {
				queue.add(top.right);
			}
		} while (!queue.isEmpty());
	}

	public void bypassingWideM() {
		bypassingWide(root);
	}

	// удаление
	public boolean binarySearch(int num) {
		// проверяет наличие и находит удаляемый элемент
		boolean check = false;
		Node temp = root;
		if (root != null) {
			while ((temp.right != null || temp.left != null) && !check) {

				if (temp.number == num) {
					check = true;
					save = temp;
				}

				if (temp.number > num && temp.left != null) {
					temp = temp.left;
				} else {
					if (temp.number < num && temp.right != null) {
						temp = temp.right;
					}

				}

				if (temp.number == num) {
					check = true;
					save = temp;
				}

			}
		}

		System.out.println(check);
		return check;

	}

	// удаление бездетного
	public void removeChildless(Node delete) {
		
		if (delete.parent.left == delete) {
			delete.parent.left = null;
		} else {
			if (delete.parent.right == delete) {
				delete.parent.right = null;
			}
		}
	}

	// удаление узла с 1 правым потомком
	public void removingNodeWith1RightsChild(Node delete) {

		if (delete.parent.left == save) {
			delete.parent.left = save.right;

		} else {
			if (delete.parent.right == save) {
				delete.parent.right = save.right;

			}
		}
		if (delete.color == "black") {
			balancingAfterRemoval(delete);
		}
	}

	// удаление узла с 1 левым потомком
	public void removingNodeWith1LeftsChild(Node delete) {

		if (delete.parent.left == save) {
			delete.parent.left = save.left;

		} else {
			if (delete.parent.right == save) {
				delete.parent.right = save.left;

			}
		}
		if (delete.color == "black") {
			balancingAfterRemoval(delete);
		}
	}

	public void delete(int num) {
		// простое удаление
		if (binarySearch(num) == true) {
			// удаление бездетного узла
			if (save.left == null && save.right == null) {
				removeChildless(save);
			} else {
				// удаление узла с 1 левым потомком
				if (save.left != null && save.right == null) {
					removingNodeWith1LeftsChild(save);

				} else {
					// удаление узла с 1 правым потомком
					if (save.left == null && save.right != null) {
						removingNodeWith1RightsChild(save);
					} else {
						// удаление узла имеющего 2 потомка
						if (save.left != null && save.right != null) {
							Node temp = save.right;
							while (temp.left != null) {
								temp = temp.left;
							}
							if (save.parent.left == save) {
								save.parent.left.number = temp.number;

								if (temp.left == null && temp.right == null) {
									removeChildless(temp);
								} else {

									removingNodeWith1RightsChild(temp);
								}
							}

							else {
								if (save.parent.right == save) {
									save.parent.right.number = temp.number;

									if (temp.left == null && temp.right == null) {
										removeChildless(temp);
									} else {

										removingNodeWith1RightsChild(temp);

									}
								}
							}
						}
					}
				}
			}
		}

	}

	// нахождение брата
	public Node brother(Node delete) {
		Node brother = null;
		if (delete.parent.left == delete) {
			brother = delete.parent.right;
		} else {
			if (delete.parent.right == delete) {
				brother = delete.left;
			}
		}

		return brother;
	}

	// если удаленный узел имеет красного брата
	public void redBrother(Node delete, Node brother) {
		brother.color = "black";
		delete.parent.color = "red";
		turnLeft(delete.parent);
	}

	// Удалённая вершина имеет чёрного брата с чёрными потомками
	public void blackBrotherWithBlackChildren(Node delete, Node brother) {
		brother.color = "red";
		delete.parent.color = "black";
	}

	// Если у черного брата правый ребёнок чёрный, а левый красный,
	public void blackBrotherWithRightBlackChildAndLeftRedChild(Node delete,
			Node brother) {
		brother.color = "red";
		brother.left.color = "red";
		turnRight(delete.parent);
	}

	// Если у черного брата правый ребёнок красный
	public void blackBrotherRightChildRed(Node delete, Node brother) {
		brother.color = delete.parent.color;
		brother.right.color = "black";
		delete.parent.color = "black";
		turnLeft(delete.parent);
	}

	// алгоритм воостановления
	public void balancingAfterRemoval(Node temp) {
		while (temp.color != "red" && temp.parent != null) {
			Node brother = brother(temp);
			// если удаленный узел имеет красного брата
			if (brother.color == "red") {
				redBrother(temp, brother);
			} else {
				// Удалённая вершина имеет чёрного брата с чёрными потомками
				if (brother.color == "black" && brother.left != null
						&& brother.left.color == "black"
						&& brother.right != null
						&& brother.right.color == "black") {
					blackBrotherWithBlackChildren(temp, brother);
				} else {
					// Если у черного брата правый ребёнок чёрный, а левый
					// красный,
					if (brother.color == "black" && brother.left != null
							&& brother.left.color == "red"
							&& brother.right != null
							&& brother.right.color == "black") {
						blackBrotherWithRightBlackChildAndLeftRedChild(temp,
								brother);
					} else {
						// Если у черного брата правый ребёнок красный
						if (brother.color == "black" && brother.right != null
								&& brother.right.color == "red") {
							blackBrotherRightChildRed(temp, brother);
						}
					}
				}
			}
		}
		temp = temp.parent;
	}
}

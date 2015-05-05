package RedBlackTree;

public class Main {
	public static void main(String args[]) {
		RedBlackTree redBlackTree=new RedBlackTree();
//		redBlackTree.addToTheTree(13);
//		redBlackTree.addToTheTree(8);
//		redBlackTree.addToTheTree(17);
//		redBlackTree.addToTheTree(1);
//		redBlackTree.addToTheTree(11);
//		redBlackTree.addToTheTree(15);
//		redBlackTree.addToTheTree(25);
//		redBlackTree.addToTheTree(6);
//		redBlackTree.addToTheTree(22);
//		redBlackTree.addToTheTree(27);
		redBlackTree.addToTheTree(10);
		redBlackTree.addToTheTree(85);
		redBlackTree.addToTheTree(15);
		redBlackTree.addToTheTree(70);
		redBlackTree.addToTheTree(20);
		redBlackTree.addToTheTree(60);
		redBlackTree.addToTheTree(30);
		redBlackTree.addToTheTree(50);
		redBlackTree.addToTheTree(65);
		redBlackTree.addToTheTree(80);
		redBlackTree.addToTheTree(90);
		redBlackTree.addToTheTree(40);
		redBlackTree.addToTheTree(5);
		redBlackTree.addToTheTree(55);
////			redBlackTree.showLKP();
		redBlackTree.bypassingWideM();
		redBlackTree.delete(60);
		System.out.println();
		redBlackTree.bypassingWideM();
		
		
	}
}

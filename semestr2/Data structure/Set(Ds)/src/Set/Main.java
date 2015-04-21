package Set;

public class Main {
	public static void main(String args[]) {
		Set set=new Set();
		set.add(2);
		set.add(1);
		set.add(3);
		set.add(94);
		set.add(5);
		set.show();
//		set.remove();
//		System.out.println(set.check(2));
//      set.completenessCheck();
//        set.checkChain();
		System.out.println();
		set.delete(2);
        set.show();
	}
}

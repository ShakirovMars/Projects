package task1;

import java.util.Scanner;

public class main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        System.out.println("vvedite e-mail");
		String m = sc.nextLine();
		sc.close();
		RegularExpressions regularExpressions=new RegularExpressions();
//		regularExpressions.regularCheck(m);
		regularExpressions.regulardDivision(m);
	}
}

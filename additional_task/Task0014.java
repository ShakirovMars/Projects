package additional_task;

import java.util.Scanner;

public class Task0014 {
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo n= ");
		n = sc.nextInt();
		sc.close();
		if ((-5 < n) & (n < 3)) {
			System.out.println("prinadlejit");
		} else
			System.out.println("ne prinadlrjit");
	}
}

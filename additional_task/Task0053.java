package additional_task;

import java.util.Scanner;

public class Task0053 {
	public static void main(String args[]) {
		int n;
		int m;
		int k = 0;
		int s;
		Scanner sc = new Scanner(System.in);
		System.out.println("vvedite n= ");
		n = sc.nextInt();
		System.out.println("vvedite m= ");
		m = sc.nextInt();
		sc.close();
		for (int i = 1; i <= m; i++) {
			s = (int) Math.pow(i, n);

			k = k + s;

		}
		System.out.println("" + k);
	}
}
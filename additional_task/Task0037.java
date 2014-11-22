package additional_task;

import java.util.Scanner;

public class Task0037 {
	public static void main(String args[]) {
		int n = 1;
		int m = 1;
		int v = 2;
		int l = 1;
		int s = 0;
		int s1 = 0;

		int k;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite k= ");
		k = sc.nextInt();
		sc.close();
		k = k - 2;
		while (k != 0) {
			s = n + v;
			s1 = m + l;

			n = s - n;
			v = s;
			m = s1 - m;
			l = s1;
			k = k - 1;

		}
		System.out.println(s + "/" + s1);
	}
}
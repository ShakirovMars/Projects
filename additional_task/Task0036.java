package additional_task;

import java.util.Scanner;

public class Task0036 {
	public static void main(String args[]) {
		double k = 1;
		double l;
		int n;
		double a = 1;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite n= ");
		n = sc.nextInt();
		sc.close();
		while (n != 0) {
			l = a * k + (1 / k);
			System.out.printf("%.1f\n", l);
			k = k + 1;
			a = l;
			n = n - 1;
		}

	}
}
package additional_task;

import java.util.Scanner;

public class Task0011 {
	public static void main(String args[]) {
		int n;
		int m;
		int y;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo  n= ");
		n = sc.nextInt();

		System.out.print("vvedite chislo  m= ");
		m = sc.nextInt();
		sc.close();
		if (m % n == 0) {
			y = m / n;
			System.out.println("y=" + y);
		} else
			System.out.println("m na n nazelo ne delitsia");

	}
}

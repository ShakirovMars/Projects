package additional_task;

import java.util.Scanner;

public class Task0015 {
	public static void main(String args[]) {
		double a;
		double b;
		double c;
		int r = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo a= ");
		a = sc.nextDouble();
		System.out.print("vvedite chislo b= ");
		b = sc.nextDouble();
		System.out.print("vvedite chislo c= ");
		c = sc.nextDouble();

		sc.close();

		if ((a == c) || (b == c) || (a == b)) {

			r = r + 1;

		}

		if (r == 0) {
			System.out.println("ne imeetsa");
		} else
			System.out.println("imeetsa");
	}
}

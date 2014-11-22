package additional_task;

import java.util.Scanner;

public class Task0022 {
	public static void main(String args[]) {
		int a;
		int b;
		int c;
		int l = 1;

		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo a= ");
		a = sc.nextInt();

		System.out.print("vvedite chislo b= ");
		b = sc.nextInt();

		System.out.print("vvedite chislo c= ");
		c = sc.nextInt();
		sc.close();
		if ((a > c) & (b > c))
			l = a + b;
		if ((b > a) & (c > a))
			l = b + c;
		if ((a > b) & (c > b))
			l = a + c;

		System.out.println(l);
	}
}
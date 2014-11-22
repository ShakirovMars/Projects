package additional_task;

import java.util.Scanner;

public class Task0016 {
	public static void main(String args[]) {
		int a;
		int b;
		int c;
		int r = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite storony a= ");
		a = sc.nextInt();
		System.out.print("vvedite storony  b= ");
		b = sc.nextInt();
		System.out.print("vvedite storony  c= ");
		c = sc.nextInt();
		sc.close();
		if (a == b)
			r = r + 1;
		if (a == c)
			r = r + 1;
		if (c == b)
			r = r + 1;
		if (r == 1)
			System.out.println("ravobedrenni");
		if (r == 3)
			System.out.println("ravnostoronni");
		if (r == 0)
			System.out.println("ne pravilni treygolnik");
	}
}

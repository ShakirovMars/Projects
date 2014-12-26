package Dobor;

import java.util.Scanner;

public class Task001 {
	public static void main(String args[]) {
		int a;
		int b;
		int c;

		double d = 0;
		double k;
		double m;
		int l;
		double x1 = 0;
		double x2 = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите числo а для функции вида y=ax^2+bx+c : ");
		a = sc.nextInt();
		System.out.print("Введите числo b для функции вида y=ax^2+bx+c : ");
		b = sc.nextInt();
		System.out.print("Введите числo c для функции вида y=ax^2+bx+c : ");
		c = sc.nextInt();
		sc.close();
		System.out.println("y=" + a + "*x^2+" + b + "x+" + c);
		d = b * b - 4 * a * c;
		k = -b + Math.sqrt(d);
		m = -b - Math.sqrt(d);
		l = (2 * a);
		if (d == 0) {
			x1 = k / l;
			x2 = x1;
			System.out.println("x1=" + x1);

		}
		if (d > 0) {
			x1 = k / l;
			x2 = m / l;
			System.out.println("x1=" + x1);
			System.out.println("x2=" + x2);
		}
		if (d < 0)
			System.out.println("уравнение не имеет решения");

	}
}

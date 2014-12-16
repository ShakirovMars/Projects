package Homework_6;

import java.util.Scanner;

public class Task0038 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		double[][] a = new double[2][2];
		double k = 0;
		double l;
		double r = 0;
		System.out.println("vvedite elementi matrisi");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {

				a[i][j] = sc.nextDouble();

			}
		}
		sc.close();
		System.out.println();
		for (int i = 0; i < 2; i++) {
			System.out.print("\n");
			for (int j = 0; j < 2; j++) {
				System.out.print(a[i][j] + "  ");
			}
		}
		k = a[0][0] * a[1][1] - a[0][1] * a[1][0];

		l = a[0][1];
		a[0][1] = a[1][0];
		a[1][0] = l;

		r = 1 / k;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				a[i][j] = a[i][j] * r;
			}
		}
		System.out.println();
		for (int i = 0; i < 2; i++) {
			System.out.print("\n");
			for (int j = 0; j < 2; j++) {
				System.out.print(a[i][j] + "  ");

			}
		}

	}
}

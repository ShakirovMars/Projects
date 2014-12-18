package Homework_7;

import java.util.Scanner;

public class Task0048 {
	public static void main(String args[]) {
		System.out.println("vvedite kolichestvo strok v massive");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("vvedite kolichestvo stolbsov ");
		int m = sc.nextInt();
		int[][] a = new int[n][m];

		int r = 0;
		System.out.println("vvedite elementi massiva");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");

			}
		}
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {
				for (int k = 0; k < m; k++) {
					if (a[i][k] > a[i][j]) {
						r = a[i][j];
						a[i][j] = a[i][k];
						a[i][k] = r;
					}

				}
			}

		}
		System.out.println("\n");
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");

			}
		}
	}
}
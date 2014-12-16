package Homework_6;

import java.util.Scanner;

public class Task0037 {
	public static void main(String args[]) {

		System.out.println("vvedite kolichestvo strok v massive");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("vvedite kolichestvo stolbsov ");
		int m = sc.nextInt();
		int[][] a = new int[n][m];

		System.out.println("vvedite elementi massiva");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				a[i][j] = sc.nextInt();
			}
		}

		int[][] b = new int[n][1];
		System.out.println("vvedite elementi vektora");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 1; j++) {

				b[i][j] = sc.nextInt();
			}
		}
		sc.close();
		int[][] c = new int[n][1];
		int l = 0;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < 1; j++) {
				for (int k = 0; k < n; k++) {
					l = l + a[i][k] * b[k][j];
				}
				c[i][j] = l;
				l = 0;
			}
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < 1; j++) {
				System.out.print(c[i][j] + " ");
			}
		}

	}

}

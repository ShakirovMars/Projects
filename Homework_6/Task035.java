package Homework_6;

import java.util.Scanner;

public class Task035 {
	public static void main(String args[]) {
		int l = 0;
		int max;
		int max1;
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
		sc.close();
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");

			}
		}
		System.out.println("\n");
		int c[] = new int[n];
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				if ((a[i][j] < 0) & (a[i][j] % 2 == 0))
					l = l + a[i][j];
			}
			c[i] = l;
			l = 0;
		}
		System.out.println("xarakteristiki:");
		for (int i = 0; i < n; i++) {
			System.out.println("n: " + c[i]);
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < m; j++) {
				if (c[i] < c[j]) {
					max1 = c[i];
					c[i] = c[j];
					c[j] = max1;

					for (int u = 0; u < m; u++) {

						max = a[i][u];
						a[i][u] = a[j][u];
						a[j][u] = max;

					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");

			}
		}

	}
}

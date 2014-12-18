package Homework_7;

import java.util.Scanner;

public class Task0047 {
	public static void main(String args[]) {
		int x = 0;
		int y = 0;
		int m = 0;
		System.out.println("vvedite kolichestvo strok v massive");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int[][] a = new int[n][n];
		System.out.println("vvedite elementi massiva");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		System.out.println("vxod:");
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");

			}
		}
		max = a[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if ((i == j) || (j == n - i - 1)) {

					if (a[i][j] > max) {
						max = a[i][j];
						x = i;
						y = j;
					}
				}

			}
		}
		System.out.println("\n");

		System.out.println("max= " + max);
		m = a[n - 1][0];
		a[n - 1][0] = a[x][y];
		a[x][y] = m;
		System.out.print("\n");
		System.out.println("vixod:");
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");

			}
		}

	}

}

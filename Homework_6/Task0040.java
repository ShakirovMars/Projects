package Homework_6;

import java.util.Scanner;

public class Task0040 {

	public static void main(String args[]) {
		int l = 0;
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

		System.out.println("1)sdvig vpravo");
		System.out.println("2)sdvig vniz");
		System.out.println("vvedite rejim");
		int p = sc.nextInt();
		System.out.println("vvedite h: ");
		int h = sc.nextInt();
		sc.close();

		System.out.println("vxod:");
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");

			}
		}

		if (p == 1) {

			while (h != 0) {

				for (int i = 0; i < n; i++) {
					l = a[i][m - 1];
					for (int j = m - 1; j >= 0; j--) {
						if (j != 0)
							a[i][j] = a[i][j - 1];
						else
							a[i][0] = l;
					}

				}
				h = h - 1;

			}
		} else if (p == 2) {
			while (h != 0) {

				for (int j = 0; j < n; j++) {
					l = a[n - 1][j];
					for (int i = n - 1; i >= 0; i--) {
						if (i != 0)
							a[i][j] = a[i - 1][j];
						else
							a[0][j] = l;
					}

				}
				h = h - 1;

			}

		}
		System.out.println("\n");
		System.out.println("vixod:");
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");

			}
		}

	}
}
package Homework_7;

import java.util.Scanner;

public class Task0045 {
	public static void main(String args[]) {
		System.out.println("vvedite kolichestvo strok v massive");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("vvedite kolichestvo stolbsov ");
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		int k = 0;
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
		System.out.println();

		int d[] = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0) {
					k++;
				}
			}
			d[i] = k;

			k = 0;

		}
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i] > 0) {
					if (a[i][j] < 0)
						r++;
				}
			}
			b[i] = r;
			r = 0;
		}
		System.out
				.println("kolichestvo otrizatelnix elementov v strokax soderjachix 0: ");
		for (int i = 0; i < n; i++) {
			System.out.println(b[i]);

		}
	}
}

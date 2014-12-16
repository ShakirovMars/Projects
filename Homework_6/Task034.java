package Homework_6;

import java.util.Scanner;

public class Task034 {
	public static void main(String[] args) {
		System.out.println("vvedite kolichestvo stolbsov");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int k = 0;

		sc.close();
		int n = m - 2;
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			k = k + 2;
			for (int j = 0; j < m; j++) {
				if (i == 0) {

					if ((j >= i) & (i + j < k + 1)) {
						a[i][j] = 1;

					} else
						a[i][j] = 0;

				} else

				if ((j >= i) & (i + j <= k)) {
					a[i][j] = 1;

				} else
					a[i][j] = 0;

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
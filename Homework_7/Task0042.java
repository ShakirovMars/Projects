package Homework_7;

import java.util.Scanner;

public class Task0042 {
	public static void main(String args[]) {

		System.out.println("vvedite kolichestvo strok v massive");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] a = new int[n][n];
		sc.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i == j) || (j == n - i - 1)) {
					a[i][j] = 1;
				} else
					a[i][j] = 0;

			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");

			}
		}
	}
}
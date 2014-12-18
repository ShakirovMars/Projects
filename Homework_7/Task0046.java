package Homework_7;

import java.util.Random;
import java.util.Scanner;

public class Task0046 {
	public static void main(String args[]) {
		System.out.println("vvedite kolichestvo strok v massive");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		int[][] a = new int[n][n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				a[i][j] = random.nextInt(10);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = a[j][i];

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
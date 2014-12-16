package Homework_6;

import java.util.Scanner;

public class Task036 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int[][] a = new int[3][3];
		int k = 0;

		System.out.println("vvedite elementi matrisi");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				a[i][j] = sc.nextInt();

			}
		}
		sc.close();
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("\n");
			for (int j = 0; j < 3; j++) {
				System.out.print(a[i][j] + " ");

			}
		}
		System.out.println();
		k = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2])
				+ (a[0][1] * a[1][2] * a[2][0]) - (a[0][2] * a[1][1] * a[2][0])
				- (a[1][0] * a[0][1] * a[2][2]) - (a[1][2] * a[2][1] * a[0][0]);

		System.out.println("det a=" + k);

	}
}

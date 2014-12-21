package Homework_8;

import java.util.Scanner;

public class Task0060 {
	public static boolean makeMasTrue(boolean[] mas1, int m) {
		boolean makeMasTrue = false;
		while (!makeMasTrue) {
			makeMasTrue = mas1[0] ^ mas1[1];
			for (int i = 2; i < m; i++) {

				makeMasTrue = makeMasTrue ^ mas1[i];
			}
			if (!makeMasTrue) {
				for (int i = 0; i < m; i++) {
					if (i > 1) {
						mas1[i - 1] = !mas1[i];
					} else
						mas1[i] = !mas1[i];
					i++;
				}
			}
		}
		System.out.println();

		for (int i = 0; i < m; i++) {
			System.out.print(" " + mas1[i]);
		}

		return makeMasTrue;
	}

	public static boolean makeMatrTrue(boolean[][] mas, int n, int m) {
		System.out.println();
		System.out.println("vixod: ");
		boolean makeMatrTrue = false;
		boolean mas1[] = new boolean[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mas1[j] = mas[i][j];
			}

			makeMatrTrue = makeMasTrue(mas1, m);
		}

		return makeMatrTrue;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("vvedite kolichestvo strok ");
		int n = sc.nextInt();
		System.out.println("vvedite kolichestvo stolbsov ");
		int m = sc.nextInt();

		boolean mas[][] = new boolean[n][m];

		System.out.println("vvedite znachenie ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mas[i][j] = sc.nextBoolean();
			}
		}
		sc.close();
		System.out.println("vxod: ");
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(mas[i][j] + " ");

			}
		}
		boolean makeMatrTrue = makeMatrTrue(mas, n, m);
		System.out.println();
		System.out.println("makeMatrTrue= " + makeMatrTrue);
	}
}

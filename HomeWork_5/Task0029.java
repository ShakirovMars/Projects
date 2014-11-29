package HomeWork_5;

import java.util.Scanner;

public class Task0029 {
	public static void main(String[] args) {
		System.out.println("vvedite kolichestvo elementov 1 massiva ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int mas1[] = new int[m];
		System.out.println("vvedite chisla 1 masssiva");
		for (int i = 0; i < m; i++) {
			mas1[i] = sc.nextInt();
		}
		System.out.println("vvedite kolichestvo elementov 2 massiva ");
		int n = sc.nextInt();
		int mas2[] = new int[n];
		System.out.println("vvedite chisla 2 masssiva");
		for (int i = 0; i < n; i++) {
			mas2[i] = sc.nextInt();
		}
		int mas3[] = new int[m + n];
		int max;
		sc.close();

		for (int i = 0; i < m + n; i++) {
			if (i < m) {
				mas3[i] = mas1[i];
			} else
				mas3[i] = mas2[i - m];

		}
		System.out.print("obiedinenie massivov: ");
		for (int i = 0; i < m + n; i++)
			System.out.print(" " + mas3[i]);
		for (int i = 0; i < m + n - 1; i++) {
			for (int j = i + 1; j < m + n; j++) {
				if (mas3[i] > mas3[j]) {
					max = mas3[i];
					mas3[i] = mas3[j];
					mas3[j] = max;

				}
			}
		}
		for (int i = 0; i < m; i++)
			mas1[i] = mas3[i];
		for (int i = 0; i < n; i++)
			mas2[i] = mas3[i + m];

		System.out.println();
		System.out.print("otsortirovanni massiv 1: ");
		for (int i = 0; i < m; i++)
			System.out.print(" " + mas1[i]);

		System.out.println();
		System.out.print("otsortirovanni massiv 2: ");
		for (int i = 0; i < n; i++)
			System.out.print(" " + mas2[i]);

	}
}

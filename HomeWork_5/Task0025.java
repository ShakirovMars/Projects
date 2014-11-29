package HomeWork_5;

import java.util.Scanner;

public class Task0025 {
	public static void main(String[] args) {

		System.out.println("¬ведите число элементов 1 массива ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int mas1[] = new int[m];

		int l = 0;
		int t;

		System.out.println("¬ведите числа первого массива");
		for (int i = 0; i < m; i++)
			mas1[i] = sc.nextInt();
		System.out.println("¬ведите число элементов 2 массива ");

		int n = sc.nextInt();
		int mas2[] = new int[n];
		System.out.println("¬ведите числа второго массива");
		for (int i = 0; i < n; i++)
			mas2[i] = sc.nextInt();
		int mas3[] = new int[n + m];

		sc.close();
		for (int i = 0; i < m + n; i++) {
			if (i < m) {
				mas3[i] = mas1[i];
			} else
				mas3[i] = mas2[i - m];
		}
		t = n + m;
		for (int i = 0; i < t; i++)
			for (int j = 0; j < t; j++)
				if ((mas3[i] == mas3[j]) & (i != j)) {
					l++;
					t = t - l / 2;
					for (int k = j; k < t - 1; k++)
						mas3[k] = mas3[k + 1];

				}
		for (int i = 0; i < t; i++)
			System.out.print(" " + mas3[i]);
	}
}

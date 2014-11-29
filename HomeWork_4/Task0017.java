package HomeWork_4;

import java.util.Scanner;

public class Task0017 {
	public static void main(String[] args) {

		System.out.println("¬ведите число элементов массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas1[] = new int[n];
		System.out.println("¬ведите числа массива");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextInt();
		}

		int r = 0;
		int max = 0;
		sc.close();

		for (int i = 1; i < n - 1; i = i + 2) {
			if (mas1[i] < mas1[i - 1]) {
				r = r + 1;
			}
			if (mas1[i] < mas1[i + 1]) {
				r = r + 1;
			} else {
				if (r > max) {
					max = r + 1;
				}
				i--;
				r = 0;
			}

		}
		if (max == 0) {
			r = r + 1;
			System.out.println("длина : " + r);
		} else {

			System.out.println(" длина : " + max);
		}

	}
}

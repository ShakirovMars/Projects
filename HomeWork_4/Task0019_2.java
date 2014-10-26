package HomeWork_4;

import java.util.Scanner;

public class Task0019_2 {
	public static void main(String[] args) {

		System.out.println("¬ведите число элементов массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas1[] = new int[n];
		System.out.println("¬ведите числа массива");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextInt();

		}
		sc.close();
		int k = 0;

		for (int i = 0; i < n; i++) {
			if (mas1[i] < 3) {
				for (int j = 0; j < n; j++) {
					if (mas1[j] > 0)
						mas1[j] = mas1[j] * mas1[j];
				}
				k = 1;
				break;
			}

		}
		if (k == 0) {
			for (int j = 0; j < n; j++) {
				mas1[j] = mas1[j] * 5;
			}
		}

		for (int i = 0; i < n; i++)
			System.out.println(mas1[i]);
	}
}

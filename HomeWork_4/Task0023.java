package HomeWork_4;

import java.util.Scanner;

public class Task0023 {
	public static void main(String[] args) {

		System.out.println("¬ведите число элементов массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas1[] = new int[n];
		int mas2[] = new int[n];
		int k = 0;
		int p = n - 1;
		System.out.println("¬ведите числа массива");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			if (mas1[i] < 0) {
				mas2[k] = mas1[i];
				k++;
			} else {
				mas2[p] = mas1[i];
				p--;
			}
		}

		for (int j = 0; j < n; j++)
			System.out.print(mas2[j] + " ");

	}
}
package HomeWork_4;

import java.util.Scanner;

public class Task0017 {
	public static void main(String[] args) {

		System.out.println("¬ведите число элементов массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double mas1[] = new double[n];
		System.out.println("¬ведите числа массива");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextDouble();
		}
		sc.close();

		int k = 0;

		for (int i = 0; i < n; i++) {

			if (mas1[i] < 0) {
				System.out.println("не верно");
				k = 1;
				break;
			} else
				k = 0;
		}
		if (k == 0)
			System.out.println("верно");
	}
}

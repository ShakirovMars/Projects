package HomeWork_4;

import java.util.Scanner;

public class Task0019_1 {
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
		double max = mas1[0];
		double min = mas1[0];

		for (int i = 0; i < n; i++)

		{
			if (mas1[i] > max)
				max = mas1[i];
			if (mas1[i] < min)
				min = mas1[i];
		}
		System.out.println("минимум= " + min);
		System.out.println("максимум= " + max);
	}
}

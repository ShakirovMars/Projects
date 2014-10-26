package HomeWork_4;

import java.util.Scanner;

public class Task0018_2 {
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

		double min = mas1[0];
		double a = 0;
		double s = 0;
		for (int i = 0; i < n; i++)

		{
			if (mas1[i] < min)
				a = i;
		}
		for (int i = 0; i < a; i++) {
			s = mas1[i] + s;
		}
		System.out.println(s);
	}
}
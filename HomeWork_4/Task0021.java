package HomeWork_4;

import java.util.Scanner;

public class Task0021 {
	public static void main(String[] args) {

		System.out.println("������� ����� ���������   ������� ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double mas1[] = new double[n];
		double mas2[] = new double[n];
		double mas3[] = new double[n];
		int k = 0;

		System.out.println("������� ����� ������� �������");
		for (int i = 0; i < n; i++)
			mas1[i] = sc.nextDouble();

		System.out.println("������� ����� ������� �������");
		for (int i = 0; i < n; i++)
			mas2[i] = sc.nextDouble();
		sc.close();

		for (int i = 0; i < n; i++) {
			mas3[i] = mas1[i] / mas2[i];
			if (mas1[i] % mas2[i] == 0)
				k++;
		}

		System.out.print("������ 1: ");
		for (int i = 0; i < n; i++)
			System.out.print(mas1[i] + " ");
		System.out.println();

		System.out.print("������ 2: ");

		for (int i = 0; i < n; i++)
			System.out.print(mas2[i] + " ");
		System.out.println();

		System.out.print("������ 3: ");

		for (int i = 0; i < n; i++)
			System.out.print(mas3[i] + " ");
		System.out.println();

		System.out.print("����� ����� � ������� 3: " + k);

	}
}
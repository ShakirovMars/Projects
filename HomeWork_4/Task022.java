package HomeWork_4;

import java.util.Scanner;

public class Task022 {
	public static void main(String[] args) {
		System.out.println("������� ����� ��������� ������� ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas1[] = new int[n];
		int mas2[] = new int[n];
		int mas3[] = new int[n];
		System.out.println("������� ����� �������");
		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < n; i = i + 2) {

			mas2[i] = mas1[i];
		}
		for (int i = 1; i < n; i = i + 2)
			mas3[i] = mas1[i];

		System.out.print("������ � ����������, �������� �� ������ ������:   ");
		for (int j = 0; j < n; j = j + 2)
			System.out.print(+mas2[j] + " ");
		System.out.println();
		System.out.print("������ � ����������, �������� �� �������� ������: ");
		for (int j = 1; j < n; j = j + 2)
			System.out.print(+mas3[j] + " ");
	}
}

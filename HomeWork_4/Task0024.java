package HomeWork_4;

import java.util.Scanner;

public class Task0024 {
	public static void main(String[] args) {

		System.out.println("������� ����� ���������  1 ������� ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int mas1[] = new int[n];

		int mas3[] = new int[n];
		int l = 0;

		System.out.println("������� ����� ������� �������");
		for (int i = 0; i < n; i++)
			mas1[i] = sc.nextInt();
		System.out.println("������� ����� ��������� 2  ������� ");
		int m = sc.nextInt();
		int mas2[] = new int[m];
		System.out.println("������� ����� ������� �������");
		for (int i = 0; i < m; i++)
			mas2[i] = sc.nextInt();
		sc.close();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (mas1[i] == mas2[j]) {
					l++;
					mas3[l - 1] = mas1[i];
				}
		}

		for (int i = 0; i < l; i++)
			System.out.print(" " + mas3[i]);
	}
}
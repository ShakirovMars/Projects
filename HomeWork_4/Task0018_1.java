package HomeWork_4;

import java.util.Scanner;

public class Task0018_1 {
	public static void main(String[] args) {

		System.out.println("������� ����� ��������� ������� ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double mas1[] = new double[n];
		System.out.println("������� ����� �������");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextDouble();
		}
		sc.close();
		double p = 1;
		for (int i = 0; i < n; i++) {

			if (mas1[i] > 0) {
				p = (double) (mas1[i] * p);

			}
		}

		System.out.println(p);
	}
}

package Homework;

import java.util.Scanner;

public class Task009 {
	public static void main(String[] args) {
		System.out.println("������� ����� n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int min = 9;

		int k = 0;
		sc.close();
		if (n / 10 != 0) {
			while (n != 0) {

				k++;
				int mas1[] = new int[k];
				for (int i = 0; i < k; i++) {
					mas1[i] = n % 10;

					if (mas1[i] > max)
						max = mas1[i];
					if (mas1[i] < min)
						min = mas1[i];

				}
				n = (n / 10);
			}
			System.out.println("������������ ����� " + max);
			System.out.println("����������� ����� " + min);
			if ((max - min) % 2 == 0) {
				System.out.println("������");
			} else
				System.out.println("��������");
		} else if (n % 2 == 0) {
			System.out.println("������");
		} else
			System.out.println("��������");

	}

}

package Homework;

import java.util.Scanner;

public class Task0010 {
	public static void main(String[] args) {
		System.out.println("������� 1-�� ����� k: ");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		System.out.println("������� 2-�� ����� n: ");
		int n = sc.nextInt();
		sc.close();
		if (k % n == 0)
			System.out.println("���������� ����� �������= " + k);

		else {
			for (int i = k; i <= (k * n); i++) {

				if ((i % k == 0) & (i % n == 0)) {

					System.out.println("���������� ����� �������=" + i);
					break;
				}
			}
		}
	}
}
package Homework;

import java.util.Scanner;

public class Task003 {
	public static void main(String[] args) {
		System.out.println("������� ����� ������� ��������� �: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("������� ������ ������� ��������� �:");
		int b = sc.nextInt();
		sc.close();
		if (a < b) {
			System.out.print("�� ������ ����� � ��������� �� � �� �: ");
			for (int i = a; i <= b; i++) {
				if (i % 2 != 0) {
					
					System.out.print(" "+i);
				}

			}
		} else
			System.out.println(" ������������ ��������");
	}
}

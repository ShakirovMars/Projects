package Homework;

import java.util.Scanner;

public class Task007 {
	public static void main(String[] args) {
		System.out.println("������� ����� ����");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		if (k <= 365) {
			if  ((k % 7 == 0)||((k+1)%7==0)) {
				System.out.println("��������");
			} else {
				System.out.println("�������");
			}
		} else
			System.out.println("������, �� ���������� ���������� ����");

	}
}

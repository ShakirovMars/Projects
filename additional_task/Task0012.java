package additional_task;

import java.util.Scanner;

public class Task0012 {
	public static void main(String args[]) {
		int n;
		int l;
		int k;
		int j = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("�������  ����������� ����o n= ");
		n = sc.nextInt();
		sc.close();
		k = n % 10;
		while (n != 0) {
			l = n % 10;
			if (l == k) {
				j = j + 1;
			} else
				j = 0;

			k = l;
			n = n / 10;
		}
		if (j == 3) {
			System.out.println("����� , ��� ��� ����� ����������");

		} else
			System.out.println("������� , ��� ��� ����� ���������� ");
	}
}

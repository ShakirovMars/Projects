package additional_task;

import java.util.Scanner;

public class Task_005 {
	public static void main(String args[]) {
		int n;
		int m;
		int k = 0;
		int l;

		Scanner sc = new Scanner(System.in);
		System.out.print("������� ������ ������ � ������ �����: ");
		n = sc.nextInt();
		sc.close();
		m = (n / 3600);
		System.out.println("������ ����� ������ � ������ �����: " + m);
		if (m > 0) {
			k = (n % 3600);
			k = k / 60;
			System.out.println("������ ����� ������ � ������ ���������� ���� "
					+ k);
		}
		if (k > 0) {
			l = (n % 3600) % 60;
			System.out
					.println("������ ������ ������ � ������ ��������� ������ "
							+ l);
		}
	}
}
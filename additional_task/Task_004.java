package additional_task;

import java.util.Scanner;

public class Task_004 {
	public static void main(String args[]) {
		int a;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("������� ������ ���������� �: ");
		a = sc.nextInt();
		sc.close();
		n = 2 * a;
		System.out.println("������� ���������� � �������� � ����� " + n);

	}
}

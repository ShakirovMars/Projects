package additional_task;

import java.util.Scanner;

public class Task_003 {
	public static void main(String args[]) {
		int a;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("������� ����o������� �������� �: ");
		a = sc.nextInt();
		sc.close();
		n = a * 4;
		System.out.println("�������� �������� ����� " + n);
	}
}

package Homework;

import java.util.Scanner;

public class Task008 {
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int n;
		int l = 0;
		System.out.print("������� ����������e ����o n : ");
		n = sc.nextInt();
		int mas1[] = new int[100];
		for (int i = 0; i < n; i++) {
			mas1[i] = n % 8;
			n = n / 8;

			if (mas1[i] == 7) {
				l++;
			}

		}
		System.out.print(l);
	}

}

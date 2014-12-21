package Homework_8;

import java.util.Scanner;

public class Task0050 {
	public static int firstNumber(int a) {
		int firstNumber = a;
		int k = 0;
		int min = 9;

		while (firstNumber != 0) {
			k++;

			if (firstNumber % 10 < min)
				min = firstNumber % 10;

			firstNumber = (firstNumber / 10);
		}

		System.out.println("min= " + min);
		return firstNumber;
	}

	public static void main(String[] args) {
		System.out.println("vvedite a ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		int firstNumber = firstNumber(a);

	}
}

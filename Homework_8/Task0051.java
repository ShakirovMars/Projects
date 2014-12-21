package Homework_8;

import java.util.Scanner;

public class Task0051 {

	public static boolean isParity(int a) {
		boolean isParity = true;
		int k = 0;
		int s = 0;

		while (a != 0) {
			k++;
			s = s + a % 10;

			a = (a / 10);

		}

		System.out.println("summa= " + s);

		if (s % 2 != 0)
			isParity = false;

		if (isParity == true) {

			System.out.println("chetnoe");
		} else
			System.out.println("ne chetnoe");

		return isParity;
	}

	public static void main(String[] args) {
		System.out.println("vvedite a ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		boolean isParity = isParity(a);

	}

}

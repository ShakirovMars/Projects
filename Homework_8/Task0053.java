package Homework_8;

import java.util.Scanner;

public class Task0053 {
	public static boolean isFivePow(int x) {
		boolean isFivePow = false;
		int m = x;
		while (x > 1) {
			m = x % 5;
			if (m == 0) {
				isFivePow = true;
			} else {
				isFivePow = false;
			}
			x = x / 5;

		}
		return isFivePow;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("vvedite n");
		int n = sc.nextInt();
		int t = 0;
		int r = 0;
		while (t != n) {
			System.out.println("vvedite " + (t + 1) + " chislo");
			int x = sc.nextInt();

			boolean isFivePow = isFivePow(x);
			if (isFivePow == true) {
				r++;
			}
			t++;
		}

		sc.close();
		System.out.println(r);

	}
}
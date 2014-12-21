package Homework_8;

import java.util.Scanner;

public class Task0054 {
	public static int maxSum(int x) {
		int maxSum = 0;

		while (x != 0) {

			maxSum = maxSum + x % 10;

			x = (x / 10);
		}

		return maxSum;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int maxSum;
		int n = 0;
		int l = 0;
		int t = 0;
		int k = 0;
		while (n != 2) {
			System.out.println("vvedite " + (n + 1) + " chislo");
			int x = sc.nextInt();
			maxSum = maxSum(x);
			n = n + 1;

			if (l < maxSum) {
				l = maxSum;
				t++;
			} else if (l == maxSum)
				k++;
		}
		sc.close();
		if ((t == 1) & (k == 0))
			System.out.println("summa v 1 chisle bolshe");
		if ((t > 1) & (k == 0))
			System.out.println("summa vo 2 chisle bolshe");
		if (k > 0)
			System.out.println("summa odinakova");
	}
}
package Homework;

import java.util.Scanner;

public class Task0010 {
	public static void main(String[] args) {
		System.out.println("¬ведите 1-ое число k: ");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		System.out.println("введите 2-ое число n: ");
		int n = sc.nextInt();
		sc.close();
		if (k % n == 0)
			System.out.println("наименьшее общее кратное= " + k);

		else {
			for (int i = k; i <= (k * n); i++) {

				if ((i % k == 0) & (i % n == 0)) {

					System.out.println("наименьшее общее кратное=" + i);
					break;
				}
			}
		}
	}
}
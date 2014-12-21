package Homework_8;

import java.util.Scanner;

public class Task0059 {
	public static boolean makeMasTrue(boolean[] mas, int n) {
		boolean makeMasTrue = false;
		while (!makeMasTrue) {
			makeMasTrue = mas[0] ^ mas[1];
			for (int i = 2; i < n; i++) {

				makeMasTrue = makeMasTrue ^ mas[i];
			}
			if (!makeMasTrue) {
				for (int i = 0; i < n; i++) {
					if (i > 1) {
						mas[i - 1] = !mas[i];
					} else
						mas[i] = !mas[i];
					i++;
				}
			}
		}
		System.out.println("vixod: ");
		for (int i = 0; i < n; i++) {
			System.out.println(mas[i]);
		}
		return makeMasTrue;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("vvedite kolichestvo elementov ");
		int n = sc.nextInt();
		boolean mas[] = new boolean[n];
		System.out.println("vvedite znachenie ");
		for (int i = 0; i < n; i++) {
			mas[i] = sc.nextBoolean();
		}

		sc.close();
		System.out.println("vxod: ");
		for (int i = 0; i < n; i++) {
			System.out.println(mas[i]);
		}
		boolean makeMasTrue = makeMasTrue(mas, n);
		System.out.println("makeMasTrue= " + makeMasTrue);
	}
}

package Homework;

import java.util.Scanner;

public class Task0014 {
	public static void main(String[] args) {
		int k;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите количество элементов k : ");
		k = sc.nextInt();
		int[] a = new int[k];
		int[] b = new int[k];
		System.out.println("Введите элементы: ");
		for (int i = 0; i < k; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if ((a[i] != -1) & (a[j] != -1)) {
					if (j != i) {
						if (a[i] == a[j]) {
							a[j] = -1;
							a[i] = -1;
						}
						sc.close();
					}
				}
			}
		}
		for (int i1 = 0; i1 < k; i1++) {
			if (a[i1] != -1) {
				b[i1] = a[i1];
				System.out.print(" "+b[i1]);
			}
		}
	}
}
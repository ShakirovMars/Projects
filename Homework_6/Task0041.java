package Homework_6;

import java.util.Scanner;

public class Task0041 {
	public static int[] sort(int[] a, int start, int end) {
		if (start >= end)
			return a;
		int i = start;
		int j = end;
		int op = i - (i - j) / 2;
		while (i < j) {
			while ((i < op) && (a[i] <= a[op]))
				i++;
			while ((j > op) && (a[j] >= a[op]))
				j--;
			if (i < j) {
				int k = a[i];
				a[i] = a[j];
				a[j] = k;
				if (i == op)
					op = j;
				else if (j == op)
					op = i;
			}
		}

		sort(a, start, op);
		sort(a, op + 1, end);
		return a;
	}

	public static void main(String[] args) {

		System.out.println("vvedite kolichestvo elementov massiva ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		System.out.println("vvedite chisla masssiva");
		for (int l = 0; l < n; l++) {
			a[l] = sc.nextInt();

		}
		sc.close();
		a = sort(a, 0, a.length - 1);
		for (int i = 0; i < n; i++)
			System.out.print(" " + a[i]);
	}
}
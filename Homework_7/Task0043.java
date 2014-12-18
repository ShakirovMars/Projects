package Homework_7;

import java.util.Scanner;

public class Task0043 {
	public static void main(String args[]) {
		int l = 0;
		int h = 0;
		int w = 0;
		int o = 0;
		int v = 0;
		int e = 0;
		int p = 0;
		int y = 0;

		System.out.println("vvedite kolichestvo strok v massive");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] a = new int[n][n];

		System.out.println("vvedite elementi massiva");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");

			}
		}
		int c[] = new int[n];
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				l = l + a[i][j];
			}
			c[i] = l;
			l = 0;
		}
		System.out.println();
		System.out.println("xarakteristiki strok:");
		for (int i = 0; i < n; i++) {
			System.out.println(i + ": " + c[i]);
		}

		int d[] = new int[n];

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {

				l = l + a[i][j];
			}
			d[j] = l;

			l = 0;
		}
		System.out.println("xarakteristiki stolbsov:");
		for (int i = 0; i < n; i++) {
			System.out.println(i + ": " + d[i]);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					h = h + a[i][j];

				} else
					h = h + 0;

			}
		}
		System.out.println("xarakteristika glavnoi diagonali: " + h);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == n - i - 1) {
					w = w + a[i][j];

				} else
					w = w + 0;

			}
		}
		System.out.println("xarakteristika pabochnoi diagonali: " + w);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i] == c[j]) {
					v = c[i];
					c[i] = -1;
					o++;

				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (d[i] == d[j]) {
					p = d[i];
					d[i] = -1;
					e++;

				}
			}
		}

		if ((o == n) && (e == n))
			y++;
		if ((v == p) && (w == h))
			y++;
		if (p == w)
			y++;
		System.out.println("\n");
		if (y == 3) {
			System.out.println("magicheski kvadrat");
		} else
			System.out.println("ne magicheski kvadrat ");

	}
}
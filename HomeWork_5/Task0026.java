package HomeWork_5;

import java.util.Scanner;

public class Task0026 {
	public static void main(String[] args) {

		System.out.println("vvedite kolichestvo elementov massiva ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int mas1[] = new int[m];
		int l = 0;
		System.out.println("vvedite chisla masssiva");
		for (int i = 0; i < m; i++) {
			mas1[i] = sc.nextInt();
		}
		System.out.println("vvedite n: ");
		int n = sc.nextInt();
		sc.close();
		l = mas1[m - 1];
		while (n != 0) {
			for (int i = m - 1; i >= 0; i--) {
				if (i != 0)
					mas1[i] = mas1[i - 1];
				else
					mas1[0] = l;
			}

			l = mas1[m - 1];
			n = n - 1;
		}
		for (int i = 0; i < m; i++)
			System.out.print(" " + mas1[i]);

	}
}

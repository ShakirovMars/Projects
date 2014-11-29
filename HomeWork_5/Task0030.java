package HomeWork_5;

import java.util.Scanner;

public class Task0030 {
	public static void main(String[] args) {
		System.out.println("vvedite kolichestvo elementov 1 massiva ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int mas1[] = new int[m];
		System.out.println("vvedite chisla 1 masssiva");
		for (int i = 0; i < m; i++) {
			mas1[i] = sc.nextInt();
		}
		System.out.println("vvedite kolichestvo preoprazovani ");
		int n = sc.nextInt();
		int k = 0;
		int b;
		sc.close();
		while (n != 0) {
			b = mas1[0];
			for (int i = 0; i < m; i++) {

				if (i < m - 1) {
					mas1[i] = mas1[i + 1] - mas1[i];
				} else
					mas1[i] = b - mas1[i];
			}
			n = n - 1;
		}
		for (int i = 0; i < m; i++) {
			if (mas1[i] != 0)
				k++;
		}

		for (int i = 0; i < m; i++) {
			System.out.println(mas1[i]);
		}
		if (k == 0) {
			System.out.println("da mojno");
		} else
			System.out.println("nelzia");
	}
}

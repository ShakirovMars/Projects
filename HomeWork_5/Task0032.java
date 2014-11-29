package HomeWork_5;

import java.util.Scanner;

public class Task0032 {

	public static void main(String[] args) {
		int max = 0;
		int max1 = 0;
		int max2 = 0;
		System.out.println("vvedite kolichestvo elementov massiva ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int mas1[] = new int[m];
		System.out.println("vvedite chisla masssiva");
		for (int i = 0; i < m; i++) {
			mas1[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < m; i++) {
			if (mas1[i] > max1)
				max1 = mas1[i];
		}
		for (int i = 0; i < m; i++) {
			if (mas1[i] < 0) {
				mas1[i] = mas1[i] * (-1);
				if (mas1[i] > max2)
					max2 = mas1[i];
			}
		}

		if (max2 > max1) {
			max = max2 * (-1);

		} else
			max = max1;
		System.out.println("max: " + max);
	}
}

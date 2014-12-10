package Homework_9;

import java.util.Scanner;

public class Task0065 {

	public static int otr(int m, int mas1[]) {
		for (int i = 0; i < m; i++) {
			if (mas1[i] < 0) {
				System.out.print(" "+mas1[i]);
			}
		}
		return m;

	}

	public static void main(String[] args) {

		System.out.println("vvedite kolichestvo elementov massiva ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int mas1[] = new int[m];

		System.out.println("vvedite chisla masssiva");
		for (int i = 0; i < m; i++) {
			mas1[i] = sc.nextInt();
		}
		sc.close();
		int otr = otr(m, mas1);

	}

}

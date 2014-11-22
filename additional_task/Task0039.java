package additional_task;

import java.util.Scanner;

public class Task0039 {
	public static void main(String args[]) {
		int n;
		int k = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite razmer posledovatelnosti n= ");
		n = sc.nextInt();
		int mas1[] = new int[n];
		System.out.println("vvedite chisla poslrdovatelnosti");
		for (int i = 0; i < n; i++)
			mas1[i] = sc.nextInt();
		sc.close();
		int s = mas1[0] % 2;
		for (int i = 0; i < n; i++) {
			while (s != 0) {

				k = k + mas1[i];
				i++;
				s = mas1[i] % 2;

			}
		}
		System.out.println(k);
	}

}

package additional_task;

import java.util.Scanner;

public class Task0040 {
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
		int s = mas1[0];
		for (int i = 0; i < n; i++) {
			while (s == mas1[i]) {
				k = k + 1;

				s = mas1[i];
				i++;
			}
		}
		System.out.println(k);
	}

}

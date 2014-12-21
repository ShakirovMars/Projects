package Homework_8;

import java.util.Scanner;

public class Task0058 {

	public static int Nod(int a, int b) {
		int Nod = 0;

		int k = 0;
		int l = 0;
		for (int i = 1; i <= a; i++) {

			if (a % i == 0) {
				k++;

			}
		}

		int mas1[] = new int[k];
		for (int j = 0; j < k; j++) {
			for (int i = 1; i <= a; i++) {

				if (a % i == 0) {

					mas1[j] = i;
					j++;
				}

			}
		}
		int t = 0;
		for (int i = 1; i <= b; i++) {

			if (b % i == 0) {
				t++;

			}
		}

		int mas2[] = new int[t];
		for (int j = 0; j < t; j++) {
			for (int i = 1; i <= a; i++) {

				if (b % i == 0) {

					mas2[j] = i;
					j++;
				}

			}
		}

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < t; j++) {
				if (mas1[i] == mas2[j]) {
					l++;

				}
			}
		}
		int mas3[] = new int[l];
		for (int m = 0; m < l; m++) {
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < t; j++) {

					if (mas1[i] == mas2[j]) {
						mas3[m] = mas1[i];
						m++;
					}
				}
			}
		}
		for (int m = 0; m < l; m++) {
			if (mas3[m] > Nod)
				Nod = mas3[m];
		}

		
		return Nod;
	}

	public static int Nod1(int a, int b, int c) {

		
		int Nod1 = Nod(c, Nod(a, b));
		return Nod1;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo a= ");
		int a = sc.nextInt();
		System.out.print("vvedite chislo b= ");
		int b = sc.nextInt();
		System.out.print("vvedite chislo c= ");
		int c = sc.nextInt();
		sc.close();
		int Nod1 = Nod1(a, b, c);
		System.out.println("Nod " + Nod1);
	}

}
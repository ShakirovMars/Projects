package Homework_9;

import java.util.Scanner;

public class Task0062 {

	public static int sumProg(int a, int d, int n, int s) {
		if (n == s) {
			return s;
		} else
			return a + sumProg(a + d, d, n - 1, s);
	}

	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.println("Vvedite 1-oe csislo");
		int a = sc.nextInt();
		System.out.println("vvedite raznost");
		int d = sc.nextInt();
		System.out.println("vvedite n");
		int n = sc.nextInt();
		sc.close();
		int s = 0;
		int sumProg = sumProg(a, d, n, s);
		System.out.println(sumProg);

	}

}

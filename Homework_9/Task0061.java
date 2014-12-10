package Homework_9;

import java.util.Scanner;

public class Task0061 {
	public static int findMembOfProg(int a, int d, int n) {
		if (n == 1) {
			return a;
		} else
			return d + findMembOfProg(a, d, n - 1);
	}

	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.println("Vvedite 1-oe csislo");
		int a = sc.nextInt();
		System.out.println("vvedite raznost");
		int d = sc.nextInt();
		System.out.println("nomer chlena");
		int n = sc.nextInt();
		sc.close();
		int findMembOfProg = findMembOfProg(a, d, n);
		System.out.println(findMembOfProg);

	}

}

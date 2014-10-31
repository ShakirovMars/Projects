package Homework;

import java.util.Scanner;

public class Task006 {
	public static void main(String[] args) {
		System.out.println("Введите количество грибов n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		if ((n < 11) || (n > 14)) {
			sc.close();
			i = n % 10;

			if (i == 1) {
				System.out.println("Мы нашли " + n + " гриб в лесу");
			}
			if ((i > 1) & (i < 5)) {
				System.out.println("Мы нашли " + n + " гриба в лесу");
			}
			if ((i > 4) || (i == 0)) {
				System.out.println("Мы нашли " + n + " грибов в лесу");
			}
		} else {
			System.out.println("Мы нашли " + n + " грибов в лесу");
		}
	}
}

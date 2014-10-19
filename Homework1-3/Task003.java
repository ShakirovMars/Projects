package Homework;

import java.util.Scanner;

public class Task003 {
	public static void main(String[] args) {
		System.out.println("¬ведите а и б, при том, что а<б");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a < b) {
			for (int i = a; i <= b; i++) {
				if (i % 2 != 0) {
					System.out.println(i);
				}

			}
		} else
			System.out.println("ошибка,а>б");
	}
}

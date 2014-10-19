package Homework;

import java.util.Scanner;

public class Task004 {
	public static void main(String args[]) {
		System.out.println("¬ведите число n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			int b = i;
			if ((b % 1 == 0) & (b % b == 0)) {
				System.out.print(b);
			}
		}

	}
}
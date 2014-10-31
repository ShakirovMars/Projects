package Homework;

import java.util.Scanner;

public class Task005 {

	public static void main(String[] args) {

		System.out.println("¬ведите числа");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int max = 0;
		int min = 0;
		sc.close();
		if ((a > b) & (a > c))
			max = a;
		if ((b > a) & (b > c))
			max = b;
		if ((c > a) & (c > b))
			max = c;
		if ((a < b) & (a < c))
			min = a;
		if ((b < a) & (b < c))
			min = b;
		if ((c < a) & (c < b))
			min = c;

		System.out.println("минимальное: " + min);
		System.out.println("максимальное: " + max);

	}
}

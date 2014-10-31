package Homework;

import java.util.Scanner;

public class Task002 {
	public static void main(String args[]) {
		int n;
		int m;
		Scanner sc = new Scanner(System.in);
		System.out.print("¬ведите трехзначное числo n : ");
		n = sc.nextInt();
		sc.close();
		m = n % 10;
		n = n / 10;
		System.out.print(m);
		System.out.print(n);
	}
}
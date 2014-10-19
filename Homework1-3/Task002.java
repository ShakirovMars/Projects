package Homework;

import java.util.Scanner;

public class Task002 {
	public static void main(String args[]) {
		System.out.println("Введите трехзначное число");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = n % 10;
		n = n / 10;
		n = n + (i * 100);
		System.out.println(n);
	}

}
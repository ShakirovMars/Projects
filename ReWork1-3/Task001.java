package Homework;

import java.util.Scanner;

public class Task001 {
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите натуральное числo n : ");
		n = sc.nextInt();
		sc.close();
		int m = 1;
		for (int i = 2; i <= n; i++)
			m = m * i;
		System.out.println(m);
		if (n < 0)
			System.out.println("Вы ввели отрицательный факториал!");
	}
}

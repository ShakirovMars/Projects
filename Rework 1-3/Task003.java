package Homework;

import java.util.Scanner;

public class Task003 {
	public static void main(String[] args) {
		System.out.println("Введите левую границу диапазона а: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("Введите правую границу диапазона б:");
		int b = sc.nextInt();
		sc.close();
		if (a < b) {
			System.out.print("не четные числа в диапазоне от а до б: ");
			for (int i = a; i <= b; i++) {
				if (i % 2 != 0) {
					
					System.out.print(" "+i);
				}

			}
		} else
			System.out.println(" неправильный диапазон");
	}
}

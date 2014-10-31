package Homework;

import java.util.Scanner;

public class Task0012 {
	public static void main(String[] args) {
		System.out.println("¬ведите число элементов массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas1[] = new int[n];

		System.out.println("¬ведите числа массива");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextInt();

		}
		sc.close();
		int max = mas1[0];
		int min = mas1[0];
		int k = 0;
		for (int i = 0; i < n; i++)

		{
			if (mas1[i] > max)
				max = mas1[i];
			if (mas1[i] < min)
				min = mas1[i];
		}
		System.out.print("номера: ");
		for (int i = 0; i < n; i++) {
			if (mas1[i] > (max + min) / 2){
				k++;
				System.out.print(i + 1 + " ");
			}	
		}
		System.out.println();
		System.out.println("количество элементов: " + k);
	}
}

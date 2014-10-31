package Homework;

import java.util.Scanner;

public class Task0016 {

	public static void main(String[] args) {
		int k = 0;
		System.out.println("¬ведите число элементов массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas1[] = new int[n];
		int max = 0;
		int s = 0;

		System.out.println("¬ведите числа массива");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < n - 1; i++) {
			if (mas1[i] < mas1[i + 1]) {
				k++;
				if (k > max) {
					s = i+1;
					max = k;
				} 
			}else {
				k = 0;
			}

		}
		max = max + 1; s=s+1;
		
		System.out.println("длина максимальной последовательности  " + max);
		int mas2[] = new int[s];
		for (int j = s - max; j < s; j++) {
			mas2[j] = mas1[j];
			System.out.print(" "+mas2[j]);
		}
	}
}
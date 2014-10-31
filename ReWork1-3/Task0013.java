package Homework;

import java.util.Scanner;

public class Task0013 {
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
	for (int i = 0; i <n; i++)
		for (int j = 0; j <n; j++)
			if ((mas1[i] == mas1[j]) & (i != j)) {
				for (int k = j; k <n- 1; k++)
					mas1[k] = mas1[k + 1];
	
	}  for (int i = 0; i <n; i++)
		System.out.print(mas1[i] + " ");
	}}

package Homework;

import java.util.Scanner;

public class Task0013_14 {
	public static void main(String[] args) {

		int mas1[] = new int[10];
		int c = 0;
		int a = 0;

		System.out.println("¬ведите числа ");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 9; i++)
			mas1[i] = sc.nextInt();
		sc.close();

		for (int i = 0; i < mas1.length; i++) {
			for (int j = 0; j < mas1.length; j++) {
				if ((mas1[i] == mas1[j]) & (i != j)) {
					c = 0;
					break;
				} else
					c = 1;
			}
			a += c;
			
		}
        int k=0;
		int mas2[] = new int[a+1];
		a = 0;
		for (int i = 0; i < mas1.length; i++) { //
			for (int j = 0; j < mas1.length; j++) {
				if ((mas1[i] == mas1[j]) & (i != j)) {
					c = 0;
					a=0;
					break;
					
				}
				else
					c = i;
                    a=1;}k=a+k;
                    if(a!=0)
			mas2[k] = mas1[c];
			
		}
		//System.out.println(a);
		for (int i = 1; i < mas2.length; i++)
			System.out.print(mas2[i] + " ");

	}
}
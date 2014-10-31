package Homework;

import java.util.Scanner;

public class Task004 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input number: ");
		int number = sc.nextInt();
 
		for (int i = 2; i <= number; i++) {
			for (int j = 2; j <= i; j++) {
				if (number % j == 0) {
					System.out.print(j + "");
					number = number / j;
				}
 
			}
		}
	}
}
 
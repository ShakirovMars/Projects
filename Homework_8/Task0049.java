package Homework_8;

import java.util.Scanner;

public class Task0049 {
	public static double solveEquation(double a, double b) {
	   double solveEquation=0;
		if(a==0){
			System.out.println("oshibka a ne doljen ravniatsa 0");
			
		} else{
			solveEquation = b / a;
			System.out.println(a + "*" + "x" + "=" + b);
			System.out.println("x= " + solveEquation);
		}
			return solveEquation;
			
	}

	public static void main(String[] args) {

		System.out.println("reshenie yravnenia vida  ax = b ");
		System.out.println("vvedite a ");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		System.out.println("vvedite b ");
		double b = sc.nextDouble();
		double solveEquation = solveEquation(a, b);
		sc.close();
	
	}
}
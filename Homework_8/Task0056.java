package Homework_8;

import java.util.Scanner;

public class Task0056 {
	public static boolean isLeapYear(int year) {
	boolean isLeapYear=true;
	int k = 0;
	int s = 0;
	if ((year % 100 == 0) & (year % 400 == 0))
		s++;
	if ((year % 4 == 0) & (year % 100 != 0) & (year % 400 != 0))
		k++;
	if (((s > 0) & (s != k)) || ((k > 0) & (s != k))) {

		isLeapYear=true;
	} else
		isLeapYear=false;
	return isLeapYear;
}	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo god= ");
		int year = sc.nextInt();
		sc.close();
	boolean	isLeapYear=isLeapYear(year);
		System.out.println(isLeapYear);
		
		
		
	}
}

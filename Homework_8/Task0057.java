package Homework_8;

import java.util.Scanner;

public class Task0057 {

	public static int countDay(int month, int year) {
		int countDay = 0;
		int k = 0;
		int s = 0;
		if ((year % 100 == 0) & (year % 400 == 0))
			s++;
		if ((year % 4 == 0) & (year % 100 != 0) & (year % 400 != 0))
			k++;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			countDay = 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			countDay = 30;
		}
		if (((s > 0) & (s != k)) || ((k > 0) & (s != k))) {
			if (month == 2)
				countDay = 29;

		} else if (month == 2)
			countDay = 28;

		return countDay;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo month= ");
		int month = sc.nextInt();
		System.out.print("vvedite chislo god= ");
		int year = sc.nextInt();

		sc.close();
		int countDay = countDay(month, year);
		System.out.println(countDay);

	}
}
package additional_task;

import java.util.Scanner;

public class Task0013 {
	public static void main(String args[]) {

		int n;
		int l;
		int k;
		int j = 0;
		int m = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите  трехзначное числo n= ");
		n = sc.nextInt();
		sc.close();
		k = n % 10;
		while (n != 0) {
			l = n % 10;
			if (l == k) {
				j = j + 1;
				m = k;
			}
			if (m == l)
				j = j + 1;
			k = l;
			n = n / 10;
		}
		if (j >= 2) {
			System.out.println("верно , что есть одинаковые цифры ");

		} else
			System.out.println("Неверно , что есть одинаковые цифры  ");
	}
}

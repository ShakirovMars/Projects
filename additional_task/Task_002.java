package additional_task;

import java.util.Scanner;

public class Task_002 {
	public static void main(String args[]) {
		int a;
		int n;
		int k;
		double y;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите числo а для функции вида y=(a^2+10)/(a+1): ");
		a = sc.nextInt();
		sc.close();
		n = a ^ 2 + 10;
		k = a + 1;
		if ((a + 1) != 0) {
			y = n / k;
			System.out.println("y=" + y);
		} else
			System.out.println("уравнение не имеет решения");

	}
}

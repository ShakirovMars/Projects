package additional_task;

import java.util.Scanner;

public class Task_004 {
	public static void main(String args[]) {
		int a;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите радиус окружности а: ");
		a = sc.nextInt();
		sc.close();
		n = 2 * a;
		System.out.println("диаметр окружности с радиусом а равен " + n);

	}
}

package additional_task;

import java.util.Scanner;

public class Task0052 {
	public static void main(String args[]) {

		int s = 0;
		int k = 0;
		int max = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("ot a= ");
		int a = sc.nextInt();
		System.out.print("do b= ");
		int b = sc.nextInt();
		sc.close();

		for (int n = a; n <= b; n++) {
			s = 0;

			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					k = i;
					s = s + k;
				}
			}
			if (s > max)
				max = s;

		}
		System.out.println("na promejytke ot a do b max summa = " + max);
	}
}

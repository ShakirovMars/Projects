package additional_task;

import java.util.Scanner;

public class Task0049 {
	public static void main(String args[]) {
		int a;
		int b;
		int k;

		int s = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print(" ot a= ");
		a = sc.nextInt();
		System.out.print(" do b= ");
		b = sc.nextInt();
		System.out.print(" chislo delitelei k= ");
		k = sc.nextInt();
		sc.close();
		for (int n = a; n <= b; n++) {
			s = 0;
			for (int i = 1; i <= n; i++) {

				if (n % i == 0) {
					s++;
				}
			}

			if (s == k)

				System.out.println(k + " " + "delitelei: " + n);

		}

	}
}

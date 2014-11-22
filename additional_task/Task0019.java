package additional_task;

import java.util.Scanner;

public class Task0019 {
	public static void main(String args[]) {
		int n;
		int k = 0;
		int s = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo n= ");
		n = sc.nextInt();
		sc.close();
		if ((n % 100 == 0) & (n % 400 == 0))
			s++;
		if ((n % 4 == 0) & (n % 100 != 0) & (n % 400 != 0))
			k++;
		if (((s > 0) & (s != k)) || ((k > 0) & (s != k))) {

			System.out.println("visokosni");
		} else
			System.out.println("ne visokosni ");
	}
}

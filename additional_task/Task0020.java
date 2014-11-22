package additional_task;

import java.util.Scanner;

public class Task0020 {
	public static void main(String args[]) {

		double n;
		double k = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo n= ");
		n = sc.nextDouble();
		sc.close();
		if (n >= 0) {
			k = n;
		} else
			k = -n;
		System.out.println(k);
	}
}

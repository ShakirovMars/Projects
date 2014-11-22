package additional_task;

import java.util.Scanner;

public class Task0028 {
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo n= ");
		n = sc.nextInt();
		sc.close();
		while (n != 0) {
			System.out.print("20 ");
			n = n - 1;
		}

	}
}

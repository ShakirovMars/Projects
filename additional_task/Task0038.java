package additional_task;

import java.util.Scanner;

public class Task0038 {
	public static void main(String args[]) {
		int n;
		int s;
		int k = 1;
		Scanner sc = new Scanner(System.in);
		System.out.print("cherez n= ");
		n = sc.nextInt();
		sc.close();
		s = n / 3;
		while (s != 0) {
			k = k * 2;
			s = s - 1;

		}
		System.out.println(k);

	}
}

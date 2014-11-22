package additional_task;

import java.util.Scanner;

public class Task0042 {
	public static void main(String args[]) {
		int n;
		int k;
		int l = 0;
		int s = 0;
		int r = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("vvedite chislo n");
		n = sc.nextInt();
		sc.close();
		k = n % 10;
		n = n / 10;
		while (n != 0) {
			l = n % 10;
			if (k < l)
				s++;
			n = n / 10;
			k = l;
			r++;
		}
		if (s == r) {
			System.out.println("verno");

		} else
			System.out.println("ne verno");
	}
}

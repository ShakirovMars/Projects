package additional_task;

import java.util.Scanner;

public class Task0018 {
	public static void main(String args[]) {
		int n;
		int l;
		int k;
		int j = 0;
		int m = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite dvuxznachnoe chislo n= ");
		n = sc.nextInt();
		sc.close();
		k = n % 10;
		while (n != 0) {
			l = n % 10;
			if ((l == 3) || (l == 6) || (l == 9)) {
				j = j + 1;
				m = k;
			}
			if ((m == 3) || (m == 6) || (m == 9)) {
				j = j + 1;
			}
			k = l;
			n = n / 10;

		}
		if (j != 0) {
			System.out.println("da,vxodit 3,6 ili 9 ");

		} else
			System.out.println(" net, ne vxodit 3,6 ili 9");
	}
}

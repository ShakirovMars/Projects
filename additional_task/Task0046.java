package additional_task;

import java.util.Scanner;

public class Task0046 {
	public static void main(String args[]) {
		int n;
		int s = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo n= ");
		n = sc.nextInt();
		sc.close();
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				s++;
		System.out.println("kolichestvo polojitelnix delitelei= " + s);
		System.out.println("kolichestvo vcex delitelei= " + s * 2);
	}
}

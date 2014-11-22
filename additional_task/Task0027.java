package additional_task;

import java.util.Scanner;

public class Task0027 {
	public static void main(String args[]) {
		double t;
		double r;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite vremia t= ");
		t = sc.nextInt();
		sc.close();
		r = t % 6;
		if ((r == 0) || (r < 3))
			System.out.println("zeleni");
		if (r == 3)
			System.out.println("jelti");
		if ((r > 3) & (r <= 5))
			System.out.println("krasni");
	}
}

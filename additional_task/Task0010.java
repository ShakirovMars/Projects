package additional_task;

import java.util.Scanner;

public class Task0010 {
	public static void main(String args[]) {
		int x;
		double y = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite x= ");
		x = sc.nextInt();
		sc.close();
		if (x <= 0)
			y = x * x;
		if (x > 0)
			y = Math.sqrt(x);
		System.out.println("y=" + y);
	}
}
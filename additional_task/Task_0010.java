package additional_task;

import java.util.Scanner;

public class Task_0010 {
	public static void main(String args[]) {
		int x;
		double y;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo x= ");
		x = sc.nextInt();
		sc.close();
		if (x > 0) {
			y = Math.sqrt(x);
		} else
			y = x * x;
		System.out.println("y= " + y);

	}
}

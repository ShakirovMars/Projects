package additional_task;

import java.util.Scanner;

public class Task_008 {
	public static void main(String args[]) {

		boolean R = false;
		int x;
		int y;
		Scanner sc = new Scanner(System.in);
		System.out.println("vvedite znachenie x  ");
		x = sc.nextInt();
		System.out.println("vvedite znachenie y");
		y = sc.nextInt();
		sc.close();
		System.out.print("a) ");
		if ((x > 2) & (y > 3))
			R = true;
		System.out.println(R);
		R = false;
		System.out.print("b) ");
		if ((x > 3) & (x < 10))
			R = true;
		System.out.println(R);

	}
}

package additional_task;

import java.util.Scanner;

public class Task0021 {
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite kolichestvo ochkov n= ");
		n = sc.nextInt();
		sc.close();
		if (n == 0)
			System.out.println("proigrish");
		if (n == 1)
			System.out.println("nichia");
		if (n == 3)
			System.out.println("pobeda");

	}
}

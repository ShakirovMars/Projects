package additional_task;

import java.util.Scanner;

public class Task_007 {
	public static void main(String args[]) {
		boolean A;
		boolean B;
		boolean C;
		boolean R;
		Scanner sc = new Scanner(System.in);
		System.out.println("vvedite znachenie A  ");
		A = sc.nextBoolean();
		System.out.println("vvedite znachenie B");
		B = sc.nextBoolean();
		System.out.println("vvedite znachenie C");
		C = sc.nextBoolean();
		sc.close();
		System.out.print("a) ");

		R = !A & B;
		System.out.println(R);
		System.out.print("b) ");

		R = A || !B;
		System.out.println(R);
		System.out.print("c) ");

		R = A & B || C;
		System.out.println(R);
	}
}

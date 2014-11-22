package additional_task;

import java.util.Scanner;

public class Task0024 {
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite chislo mesiasa n= ");
		n = sc.nextInt();
		sc.close();

		switch (n) {
		case 12:
		case 1:
		case 2:
			System.out.println("zima");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("vesna");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("leto");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("osen");
			break;
		default:
			System.out.println("net takogo mesiasa");

		}
	}

}

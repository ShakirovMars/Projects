package additional_task;

import java.util.Scanner;

public class Task0025 {
	public static void main(String args[]) {
		int k;
		Scanner sc = new Scanner(System.in);
		System.out.print("vvedite nomer karti  k= ");
		k = sc.nextInt();
		sc.close();

		switch (k) {
		case 6:
			System.out.println("shesterka");
			break;
		case 7:

			System.out.println("semerka");
			break;

		case 8:
			System.out.println("vosmerka");
			break;
		case 9:

			System.out.println("deviatka");
			break;
		case 10:
			System.out.println("desiatka");
			break;
		case 11:
			System.out.println("valet");
			break;
		case 12:
			System.out.println("dama");
			break;
		case 13:
			System.out.println("korol");
			break;
		case 14:
			System.out.println("tyz");
			break;

		default:
			System.out.println("net takogi karti");

		}
	}

}

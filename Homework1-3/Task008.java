package Homework;
import java.util.Scanner;
public class Task008 {
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int k;
		int s = 0;
		System.out.print("¬ведите натуральноe числo k : ");
		k = sc.nextInt();
		int mass[] = new int[10];
		for (int i = 0; i < k; i++) {
			mass[i] = k % 8;
			k = k / 8;

			if (mass[i] == 7) {
				s++;
			}

		}
		System.out.print(s);
	}

}

		


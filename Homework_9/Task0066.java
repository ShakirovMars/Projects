package Homework_9;

import java.util.Scanner;

public class Task0066 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int start;
		int end;
		int start2;
		int end2;
		int l;

		System.out.println("vvedite slovo");
		String m = sc.nextLine();
		sc.close();
		String str = m;
		str += "#";

		l = str.indexOf("#");

		if (l % 2 == 0) {
			start = 0;
			end = l / 2;
			start2 = l / 2;
			end2 = l;

		} else {
			start = 0;
			end = l / 2;
			start2 = (l / 2) + 1;
			end2 = l;
		}

		String buf = m.substring(start, end);

		String buf2 = m.substring(start2, end2);
		String buf2b = new StringBuffer(buf2).reverse().toString();

		if (buf.equals(buf2b) == true) {
			System.out.println("yes");
		} else
			System.out.println("no");

	}

}

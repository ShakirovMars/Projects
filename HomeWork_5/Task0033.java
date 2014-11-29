package HomeWork_5;

import java.util.Scanner;

public class Task0033 {
	public static void main(String[] args) {
		System.out.println("vvedite kolichestvo simvolov massiva ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
	char mas1[] = new char [m];
		System.out.println("vvedite simvoli masssiva");
		for (int i = 0; i < m; i++) {
			mas1[i] = sc.nextchar;
		}
	}
}
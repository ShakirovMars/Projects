package HomeWork_5;

import java.util.Scanner;

public class Task0031 {
	public static void main(String[] args) {

		System.out.println("vvedite kolichestvo elementov massiva ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int mas1[] = new int[m];
        int k=0;
		System.out.println("vvedite chisla masssiva");
		for (int i = 0; i < m; i++) {
			mas1[i] = sc.nextInt();
		}
		sc.close();
		System.out.print("icxodni massiv: ");
		for (int i = 0; i < m; i++)

			System.out.print(" " + mas1[i]);
		System.out.println();
		System.out.print("novi massiv: ");
		System.out.print(0);
			for (int j= 0; j < m-1; j++){
			mas1[j] = mas1[j]+k; 
			k=mas1[j];
			System.out.print(" "+mas1[j]);
		
		
			}
	}
}

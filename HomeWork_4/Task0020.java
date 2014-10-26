package HomeWork_4;

import java.util.Scanner;

public class Task0020 {
	public static void main(String[] args) {

		System.out.println("¬ведите число элементов  массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k=0;
		int mas1[] = new int[n];
		System.out.println("¬ведите числа массива");
		for (int i = 0; i < n; i++)
			mas1[i] = sc.nextInt();
		sc.close();
		for (int i = 0; i < n; i++){
		if((mas1[i]>mas1[i+1])&(mas1[i+1] <mas1[i+2]))
		k++;
		
		
		} System.out.println(k);
	}
}
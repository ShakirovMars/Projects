package Homework;

import java.util.Scanner;

public class itis_12 {
	public static void main(String[] args) {
		int mas1[] = new int[10];
		System.out.println("������� ����� ");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 9; i++)
			mas1[i] = sc.nextInt();
		sc.close();
		int max = mas1[0];
		int min = mas1[0];
		
		for (int i = 0; i <= 9; i++)
			
		{
            if (mas1[i] > max)
				max = mas1[i];
			if (mas1[i] < min)
				min = mas1[i];
			}
	//	System.out.println(max+" "+min);
		for (int i = 0; i <= 9; i++){
		 if (mas1[i]>(max+min)/2)
		
		 System.out.print(i+1+" ");}
		
}
	}

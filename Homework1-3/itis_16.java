package Homework;

import java.util.Scanner;

public class itis_16 {

	public static void main(String[] args) {
		int mas1[] = new int[10];
		System.out.println("¬ведите числа ");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 9; i++)
			mas1[i] = sc.nextInt();
		sc.close();
		int c=1;
		int k=0;
		int t=0;
		int y=0;
		
			for (int i=1;i<10;i++)

		{ 
			if (mas1[i] >= mas1[i-1] ){
				
				c++;
			    k=i;	}
			else if(t<c){t=c;c=0;y=k;k=0;}
			 	
		}
			System.out.println(y);
			System.out.println(t);
			
			
	}

}

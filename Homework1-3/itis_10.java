package Homework;

import java.util.Scanner;

public class itis_10 {
	public static void main(String[] args) {
		System.out.println("������� �����");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();

		if (m < n) {int a=m;m=n;n=a;}
		
		if (m % n == 0)
			System.out.println("���=" + m);
		
		else{
			for(int i=m;i<=(m*n);i++){
				
				if((i%m==0)&(i%n==0)){
					
					System.out.println("���=" + i);
			break;}}
		}
		
	}
}
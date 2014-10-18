package Homework;

import java.util.Scanner;

public class Task009{
	public static void main(String [] args){
		System.out.println("Введите число");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int min=9;
		int i;
		int j;
		int max=0;
		if (n>=10){
			while(n!=0){
				i=(n%10);
				if (i>max){
					max=i;
				}
				if (i<min){
					min=i;
				}
				n=(n/10);
			}
		}
		else System.out.println("не получается");
		if ((max-min)%2==0){
			System.out.println("чётное");
			}
			else System.out.println("нечетное");
		}
}

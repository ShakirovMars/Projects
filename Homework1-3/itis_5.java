package Homework;

import java.util.Scanner;
public class itis_5 {
	
	public static void main(String [] args){
		System.out.println("Введите числа");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		if ((a>b)& (a>c)&(b<c)){	
		System.out.println(a + " максимальное");
		System.out.println(b + " минимальное");
		}
		if ((a>b)&(a>c)&(c<b)){
		System.out.println(a + " максимальное");
		System.out.println(c + " минимальное");
		}
		if ((b>a)&(b>c)&(a<c)){
		System.out.println(b + " максимальное");
		System.out.println(a + " минимальное");
		}
		if ((b>a)&(b>c)&(c<a)){
		System.out.println(b + " максимальное");
		System.out.println(c + " минимальное");
		}
		if ((c>a)&(c>b)&(b<a)){
		System.out.println(c + " максимальное");
		System.out.println(b + " минимальное");
		}
		if ((c>a)&(c>b)&(a<b)){
		System.out.println(c + " максимальное");
		System.out.println(a + " минимальное");
		}
		}
		}


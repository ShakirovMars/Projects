package Homework;

import java.util.Scanner;
public class itis_5 {
	
	public static void main(String [] args){
		System.out.println("������� �����");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		if ((a>b)& (a>c)&(b<c)){	
		System.out.println(a + " ������������");
		System.out.println(b + " �����������");
		}
		if ((a>b)&(a>c)&(c<b)){
		System.out.println(a + " ������������");
		System.out.println(c + " �����������");
		}
		if ((b>a)&(b>c)&(a<c)){
		System.out.println(b + " ������������");
		System.out.println(a + " �����������");
		}
		if ((b>a)&(b>c)&(c<a)){
		System.out.println(b + " ������������");
		System.out.println(c + " �����������");
		}
		if ((c>a)&(c>b)&(b<a)){
		System.out.println(c + " ������������");
		System.out.println(b + " �����������");
		}
		if ((c>a)&(c>b)&(a<b)){
		System.out.println(c + " ������������");
		System.out.println(a + " �����������");
		}
		}
		}


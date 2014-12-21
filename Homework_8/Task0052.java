package Homework_8;

import java.util.Scanner;

public class Task0052 {
	public static boolean isRight(boolean x,boolean y,boolean z) {
		boolean isRight=true;
	
		isRight=x||y||z;
	
	
	return isRight;
	}
	public static void main(String[] args) {
		System.out.println("vvedite x ");
		Scanner sc = new Scanner(System.in);
		boolean x = sc.nextBoolean();
		System.out.println("vvedite y ");
		boolean y= sc.nextBoolean();
		System.out.println("vvedite z ");
		boolean z= sc.nextBoolean();
		sc.close();
		boolean isRight =  isRight(x,y,z);
        System.out.println(isRight);
	}

}


package Homework_9;

import java.util.Scanner;

public class Task0064 {
	static  int reverseNumber(int n){
	if (n != 0) {
		
		System.out.print(n % 10);
		return reverseNumber(n/10) ;
		
	} else
	return n;
}

	public static void main(String[] args) {
		Scanner sc;
		
		sc = new Scanner(System.in);
		System.out.println("vvedite  chislo");
		int n = sc.nextInt();
		sc.close();
		int reverseNumber=reverseNumber(n);
		}

}


		

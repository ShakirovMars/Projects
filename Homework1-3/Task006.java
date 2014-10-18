package Homework;
import java.util.Scanner;
public class Task006 {
	public static void main(String [] args){
		System.out.println("Введите число");
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		int i=k%10;
		if (k==1) {
			System.out.println("Мы нашли " + k + " гриб в лесу!");
		}
		else if ((k>=2) & (k <= 4)){
			System.out.println("Мы нашли " + k + " гриба в лесу!");
		}
		else
			System.out.println("Мы нашли " + k + " грибов в лесу!");
		
	}
}


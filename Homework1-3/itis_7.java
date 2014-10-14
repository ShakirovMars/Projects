package Homework;
import java.util.Scanner;
public class itis_7 {
	public static void main(String [] args){
		System.out.println("¬ведите число года");
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		sc.close();
		if (k<=365) {
		if ((k%6==0)||(k%7==0)){
			System.out.println("выходной");
		}
				else{
					System.out.println("рабочий");
					}
					}
				else 
				System.out.println("ошибка, дней в году 365(ну или 364)");	
		   
	}
		}
		
		


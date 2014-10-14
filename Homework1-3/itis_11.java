package Homework;
import java.util.Scanner;
public class itis_11 {
	public static void main(String[] args) {
		System.out.println("¬ведите числа a и p ");
		Scanner sc=new Scanner(System.in);
          int a = sc.nextInt();
           int  p= sc.nextInt();
            sc.close();
            int mas1[]=new int[10];
            mas1[0]=a;
          for(int i=1;i<=9; i++) 
            	mas1[i] = mas1[i-1]+p;
            	for(int i = 0; i <= mas1.length  - 1; i++) {
            		  System.out.print(mas1[i] + "  ");
            		}
                 }
	          }
            

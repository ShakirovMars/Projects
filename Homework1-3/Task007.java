package Homework;
import java.util.Scanner;
public class Task007 {
	public static void main(String [] args){
		System.out.println("������� ����� ����");
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		sc.close();
		if (k<=365) {
		if ((k%6==0)||(k%7==0)){
			System.out.println("��������");
		}
				else{
					System.out.println("�������");
					}
					}
				else 
				System.out.println("������, ���� � ���� 365(�� ��� 364)");	
		   
	}
		}
		
		


package Homework;
import java.util.Scanner;
public class itis_6 {
	public static void main(String [] args){
		System.out.println("������� �����");
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		int i=k%10;
		if (k==1) {
			System.out.println("�� ����� " + k + " ���� � ����!");
		}
		else if ((k>=2) & (k <= 4)){
			System.out.println("�� ����� " + k + " ����� � ����!");
		}
		else
			System.out.println("�� ����� " + k + " ������ � ����!");
		
	}
}


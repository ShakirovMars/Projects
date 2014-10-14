package Homework;
import java.util.Scanner;
public class itis_13_15 {
	public static void main(String[] args) {
		int mas1[] = new int[10];
		System.out.println("¬ведите числа ");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 9; i++)
			mas1[i] = sc.nextInt();
		sc.close();
		
		for(int i=0;i<mas1.length;i++)
			for(int j=0;j<mas1.length;j++)
				if((mas1[i]==mas1[j])&(i!=j)){
					for(int k=j;k<mas1.length-1;k++)
						mas1[k]=mas1[k+1];
					mas1[mas1.length-1]=0;
					
				}
		for(int i=0;i<mas1.length;i++)
		System.out.print(mas1[i]+" ");
}
}
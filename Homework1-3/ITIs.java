package Homework;
import java.util.Scanner;

public class ITIs{
    public static void main(String args[]) {
       int n;
        do {
            Scanner ttt= new Scanner(System.in);
             System.out.print("������� ��������� ���������� ����� n : ");
              n = ttt.nextInt();
               int result = 1;
                for (int i = 2; i <= n; i++)
                  result *= i;
                  System.out.println(result);
                if (n == 0 || n == 1)
                 System.out.println(result);
             if(n < 0)
             System.out.println("�� ����� ������������� ���������!");
        } while (n < 0);{System.out.println("�����");}
    }
}
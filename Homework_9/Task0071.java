package Homework_9;

import java.util.Scanner;

public class Task0071 {
	public static void main(String args[]) {
		int t = 0;
		int l;
		int z;
		int y;
		System.out.println("vvedite virajenie");
		Scanner sc = new Scanner(System.in);

		StringBuffer k = new StringBuffer(sc.nextLine());

		System.out.println("vvedite slovo kotoroe xotite izmenit");
		String m = sc.nextLine();

		System.out.println("vvedite slovo ");
		String v = sc.nextLine();
		
		sc.close();
		l = k.lastIndexOf(m);
		y = k.indexOf(m);
		String str1 = m;
		str1 += "#";
		z = str1.indexOf("#");

		while ((l >= y) & (l > -1)) {
			y = k.indexOf(m);
			k.insert( y + z,v);
			k.delete(y, y + z);
            
			t++;

			l = k.lastIndexOf(m);
		}
		if (t != 0)
			System.out.println(k);
		else {
			System.out.println("nety");
		}

	}

}

 

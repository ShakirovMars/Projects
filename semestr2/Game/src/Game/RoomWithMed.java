package Game;

import java.util.Scanner;

public class RoomWithMed {
	public static boolean med;

	public static void RoomWithMed( Player player) {
	
		System.out.println("�� ����� �������");
		System.out.println("��������");
		System.out.println("����������: ������� ����� ��� �� �����");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();
		player.moveByCommand(cmd1);
		if ((player.getTake() == true) && (player.getXP() <= 200)) {
			System.out.println("�������, �� ��������� ��������");
			System.out.println("����� " + player.getXP());
			player.getNottake();
			med = true;
		} else {
			if (player.getTake() == false && (player.getXP() >= 200)) {
				System.out
						.println("� ��� ������������ ��������,������ ������ �� ��� �����");
				System.out.println(player.getXP());
			} else {
				if (player.getXP() < 200) {
					System.out.println("A,����!!");
					System.out.println("����� " + player.getXP());
				}
			}
		}
	}
}

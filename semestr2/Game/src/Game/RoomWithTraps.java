package Game;

import java.util.Scanner;

public class RoomWithTraps {
	public static boolean trap;

	public static void RoomWithTraps( Player player) {

		System.out.println("����� ���� �������!!!");
		System.out.println("������");
		System.out
				.println("����������: ������� ������  ��� ������, �� ������ ������ �� ������������� � ��������� �����");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getPass() == true) {
			System.out.println("�������, �� ������ ����� �������!");
			player.XP = player.XP - 30;
			System.out.println("����� " + player.getXP());
			trap = true;

		}
		if (player.getElope() == true) {
			System.out.println("�� ������, �������� �������� ���� ������");
			System.out.println("����� " + player.getXP());
		}
	}
}

package Game;

import java.util.Scanner;

public class RoomWithRobots {
	public static boolean robot;

	public static void RoomWithRobots( Player player) {

		System.out.println("�� ��������� �����������!!!");
		System.out.println("��������");
		System.out
				.println("����������: ������� ����� ��� ������, �� ������ ������ �� ������������� � ��������� �����");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getAttack() == true) {

			System.out.println("�������, �� �������� �����������!");
			System.out.println("�������� ����������,��� ������ ���� �������");
			player.XP = player.XP - 50;
			System.out.println("����� " + player.getXP());
			robot = true;
			player.tranquility();
		}
		if (player.getElope() == true) {
			System.out.println("�� ������, �������� �������� ���� ������");
			System.out.println("����� " + player.getXP());
		}
	}
}

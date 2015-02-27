package Game;

import java.util.Scanner;

public class RoomWithRobots {
	public static boolean robot;

	public static void RoomWithRobots( Player player) {

		System.out.println("Вы встретили мышероботов!!!");
		System.out.println("Атакуйте");
		System.out
				.println("Подсказска: введите атака или бежать, но учтите сбежав вы переместитесь в начальную точку");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getAttack() == true) {

			System.out.println("Отлично, вы победили мышероботов!");
			System.out.println("Разведка докладывет,что правее есть аптечка");
			player.XP = player.XP - 50;
			System.out.println("Жизнь " + player.getXP());
			robot = true;
			player.tranquility();
		}
		if (player.getElope() == true) {
			System.out.println("Вы бежали, придется начинать путь заново");
			System.out.println("Жизнь " + player.getXP());
		}
	}
}

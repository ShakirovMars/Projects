package Game;

import java.util.Scanner;

public class RoomWithTraps {
	public static boolean trap;

	public static void RoomWithTraps( Player player) {

		System.out.println("Перед вами ловушки!!!");
		System.out.println("Пройти");
		System.out
				.println("Подсказска: введите пройти  или бежать, но учтите сбежав вы переместитесь в начальную точку");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getPass() == true) {
			System.out.println("Отлично, вы прошли через ловушки!");
			player.XP = player.XP - 30;
			System.out.println("Жизнь " + player.getXP());
			trap = true;

		}
		if (player.getElope() == true) {
			System.out.println("Вы бежали, придется начинать путь заново");
			System.out.println("Жизнь " + player.getXP());
		}
	}
}

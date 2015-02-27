package Game;

import java.util.Scanner;

public class RoomWithMed {
	public static boolean med;

	public static void RoomWithMed( Player player) {
	
		System.out.println("Вы нашли аптечку");
		System.out.println("Возьмите");
		System.out.println("Подсказска: введите взять или не брать");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();
		player.moveByCommand(cmd1);
		if ((player.getTake() == true) && (player.getXP() <= 200)) {
			System.out.println("Отлично, вы пополнили здоровье");
			System.out.println("Жизнь " + player.getXP());
			player.getNottake();
			med = true;
		} else {
			if (player.getTake() == false && (player.getXP() >= 200)) {
				System.out
						.println("У вас максимальное здоровье,можете прийти за ним позже");
				System.out.println(player.getXP());
			} else {
				if (player.getXP() < 200) {
					System.out.println("A,зряя!!");
					System.out.println("Жизнь " + player.getXP());
				}
			}
		}
	}
}

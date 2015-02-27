package Game;

import java.util.Scanner;

public class FirstFloor {
	private static boolean Ninja;
	private Player player;
	private static String[][] floor;
	private int winI;
	private int winJ;

	private static int n;
	private static int m;
	private static boolean motion;

	public FirstFloor(Player player) {
		this.player = player;
		winI = 3;
		winJ = 3;
		n = 4;
		m = 4;

	}

	private boolean CheckWinner() {
		boolean WIN = false;
		boolean GameOver = false;
		if ((player.getI() == 0) && (player.getJ() == 1)
				&& (RoomWithNinja.Ninja == false)) {
			RoomWithNinja.RoomWithNinja(player);
		} else {
			if ((player.getI() == 0) && (player.getJ() == 1)
					&& (RoomWithNinja.Ninja == true)) {
				System.out.println("Вы уже победили ниндзя в этой комнате");
			}
		}
		if ((player.getI() == 2) && (player.getJ() == 2)
				&& (RoomWithXan.xan == false)) {
			RoomWithXan.RoomWithXan(player);
		} else {
			if ((player.getI() == 2) && (player.getJ() == 2)
					&& (RoomWithXan.xan == true)) {
				System.out.println("Вы уже победили хана в этой конате");
			}
		}
		if ((player.getI() == 0) && (player.getJ() == 2)
				&& (RoomWithMed.med == false)) {
			RoomWithMed.RoomWithMed(player);
		} else {
			if ((player.getI() == 0) && (player.getJ() == 2)
					&& (RoomWithMed.med == true)) {
				System.out.println("Вы уже взяли аптечку из этой комнаты");
			}

		}
		if ((player.getI() == 3) && (player.getJ() == 2)
				&& (RoomWithMedmax.medmax == false)) {
			RoomWithMedmax.RoomWithMedmax(player);
		} else {
			if ((player.getI() == 3) && (player.getJ() == 2)
					&& (RoomWithMedmax.medmax == true)) {
				System.out.println("Вы уже взяли аптечку из этой комнаты");
			}
		}
		if ((player.getI() == 3) && (player.getJ() == 1)
				&& (RoomWithRobots.robot == false)) {
			RoomWithRobots.RoomWithRobots(player);
		} else {
			if ((player.getI() == 3) && (player.getJ() == 1)
					&& (RoomWithRobots.robot == true)) {
				System.out
						.println("Вы уже победили мышероботов в этом месте!!!");
			}
		}
		if ((player.getI() == 1) && (player.getJ() == 0)
				&& (RoomWithPurpledragons.purpledragons == false)) {
			RoomWithPurpledragons.RoomWithPurpledragons(player);
		} else {
			if ((player.getI() == 1) && (player.getJ() == 0)
					&& (RoomWithPurpledragons.purpledragons == true)) {
				System.out
						.println("Вы уже победили банду пурпурных драконов здесь!!!");
			}
		}
		if ((player.getI() == 2) && (player.getJ() == 3)
				&& (RoomWithTraps.trap == false)) {
			RoomWithTraps.RoomWithTraps(player);
		} else {
			if ((player.getI() == 2) && (player.getJ() == 3)
					&& (RoomWithTraps.trap == true)) {
				System.out.println("Вы уже прошли через ловушки!!!");
			}
		}
		if ((player.getI() == winI) && (player.getJ() == winJ)) {
			WIN = true;
		}
		if (player.XP == 0) {
			GameOver = true;
		}
		if (WIN == true) {
			System.out.println("УРА!!!! Вы победили!!!");
		}
		if (GameOver == true) {
			System.out.println("Ничего страшного! Попробуйте сыграть еще раз");
		}

		return WIN || GameOver;
	}

	public void play() {
		Scanner scan = new Scanner(System.in);
		Pole.pole(n, m, motion, player);

		while (!CheckWinner()) {
			System.out.println("Введите команду для движения ");
			String cmd1 = scan.next();
			player.moveByCommand(cmd1);
			motion = true;
			Pole.pole(n, m, motion, player);

		}
	}
}
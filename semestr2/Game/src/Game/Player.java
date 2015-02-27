package Game;

public class Player {
	public int XP;
	private int i;
	private int j;
	private boolean attack;
	private boolean elope;
	private boolean take;
	private boolean pass;

	public Player() {
		i = 0;
		j = 0;
		XP = 200;
		attack = false;
		elope = false;
		take = false;
		pass = false;
	}

	public int getI() {
		return i;

	}

	public int getJ() {
		return j;
	}

	public int getXP() {
		return XP;
	}

	public void getName() {
		System.out.print("Я ");
	}

	public void moveUp() {
		if ((i != 0) && (i <= 3)) {
			i--;
		} else
			System.out.println("Стена!");
	}

	public void moveDown() {
		if (i < 3) {
			i++;
		} else
			System.out.println("Стена!");

	}

	public void moveLeft() {
		if ((j != 0) && (j <= 3)) {
			j--;
		} else
			System.out.println("Стена!");
	}

	public void moveRight() {
		if (j < 3) {
			j++;
		} else
			System.out.println("Стена!");
	}

	public void XP() {
		System.out.println("XP=" + XP);
	}

	public boolean getAttack() {
		return attack;
	}

	public boolean getPass() {
		return pass;
	}

	public boolean getElope() {
		return elope;
	}

	public boolean getTake() {
		return take;
	}

	public boolean getNottake() {
		return take;
	}

	public void movePass() {
		pass = true;
	}

	public void moveTake() {
		if ((i == 0)&& (j == 2)) {
			if (XP == 200) {
				take = false;
			} else {
				if (XP + 100 > 200) {
					XP = 200;
					take = true;
				} else {
					XP = XP + 100;
					take = true;
				}
			}
		} else {
			if (XP == 200) {
				take = false;
			} else {
				if (XP < 200) {
					XP = 200;
					take = true;
				}
			}
		}

	}

	public void moveNottake() {
		take = false;
	}

	public void moveAttack() {
		attack = true;

	}

	public void tranquility() {
		attack = false;
	}

	public void moveElope() {
		elope = true;
		XP = XP - 10;
		i = 0;
		j = 0;
	}

	public void moveByCommand(String command) {
		switch (command) {
		case "вверх":
			moveUp();
			break;
		case "вниз":
			moveDown();
			break;
		case "вправо":
			moveRight();
			break;
		case "влево":
			moveLeft();
			break;
		case "атака":
			moveAttack();
			break;
		case "бежать":
			moveElope();
			break;
		case "взять":
			moveTake();
			break;
		case "не брать":
			moveNottake();
			break;
		case "пройти":
			movePass();
			break;
		default:
			break;
		}
	}

}

package Svet;

public class Svet {
	public String color;

	public void setColor(String color) {
		this.color = color;
	}

	public void switchToGreen() {
		color = "green";
	}

	public void switchToYellow() {
		color = "yellow";
	}

	public void switchToRed() {
		color = "red";
	}

	public void work(String color) {
		int n = 0;
		while (n != 7) {
			switch (color) {
			case "red":
				switchToYellow();
				break;
			case "yellow":
				switchToGreen();
				break;
			case "green":
				switchToRed();
				break;
			default:
				break;
			}
			n++;
		}
	}
}
package Svet;

public class Main {

	public static void main(String[] args) {
		Svet svet = new Svet();
		svet.setColor("green");
		System.out.println(svet.color);
		svet.work(svet.color);
		System.out.println(svet.color);
	}
}

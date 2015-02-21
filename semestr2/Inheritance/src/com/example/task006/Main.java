package com.example.task006;

public class Main {
	public static void main(String[] args) {
		Xordovie[] xordovie = new Xordovie[29];
		xordovie[0] = new Sobaka();
		xordovie[1] = new Belichie();
		xordovie[2] = new Grizyni();
		xordovie[3] = new Kitoobraznie();
		xordovie[4] = new Koshachie();
		xordovie[5] = new Krolic();
		xordovie[6] = new Kynie();
		xordovie[7] = new Lisisa();
		xordovie[8] = new Medvejie();
		xordovie[9] = new Mishinie();
		xordovie[10] = new Mlekopitaychie();
		xordovie[11] = new Nasekomoydnie();
		xordovie[12] = new Parnokopitnie();
		xordovie[13] = new Peses();
		xordovie[14] = new Presmikaychiesia();
		xordovie[15] = new Primati();
		xordovie[16] = new Psovie();
		xordovie[17] = new Ptisi();
		xordovie[18] = new Ribi();
		xordovie[19] = new Rykokrilie();
		xordovie[20] = new Shakal();
		xordovie[21] = new Volk();
		xordovie[22] = new Xichnie();
		xordovie[23] = new Xobotnie();
		xordovie[24] = new Zaychie();
		xordovie[25] = new Zays();
		xordovie[26] = new ZaysBeliak();
		xordovie[27] = new ZaysRysak();
		xordovie[28] = new Zemnovodnie();
		getName(xordovie);
	}

	private static void getName(Xordovie xordovie[]) {
		for (int i = 0; i < xordovie.length; i++) {
			xordovie[i].getName();
			System.out.println("\n");
		}

	}
}

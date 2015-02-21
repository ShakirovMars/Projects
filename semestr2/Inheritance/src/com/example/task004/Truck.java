package com.example.task004;

public class Truck extends Vehicle {
	public int tonnage;
	public int were;

	public Truck(int mTonnage, int mWere) {
		tonnage = mTonnage;
		were = mWere;
	}

	public void setTonnage(int mTonnage) {
		if (mTonnage <= 2000) {
			tonnage = mTonnage;
		} else
			System.out.println("Error slishkom bolshaya gryzopodemnost");
	}

	public void setWere(int mWere) {
		if (mWere <= tonnage) {
			were = mWere;
		} else
			System.out.println("Error slishkom mnogo lydei");
	}

	public void postLoads(int loading) {
		if (loading + were > tonnage) {
			System.out.println("Error peregryz");
		} else {
			if (loading + were < tonnage) {
				System.out.println("Dobavit gryz");
				were = loading + were;
			} else
				System.out.println("Yje zagryjen");
		}
	}

	public void unloadGoods(int unload) {
		if (were == 0) {
			System.out.println("Net gryza");
		} else
			System.out.println("Vigryzit gryz");
		were = were - unload;
	}
}

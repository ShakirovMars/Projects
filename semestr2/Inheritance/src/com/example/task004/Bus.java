package com.example.task004;

public class Bus extends Vehicle {
	public int capacity;
	public int were;

	public Bus(int mCapacity,int mWere ) {
		were = mWere;
		capacity = mCapacity;
	}

	

	public void setCapacity(int mCapacity) {
		if (mCapacity <= 120) {
			capacity = mCapacity;
		}
         else
			System.out.println("Error slishkom bolshaya vmestimost");
	}

	

	public void setWere(int  mWere) {
		if ( mWere <= capacity) {
			were =  mWere;
		}
         else
			System.out.println("Error slishkom mnogo lydei");
	}
	public void peopleLogged(int logged) {
		if (logged+were>capacity) {
			System.out.println("Error peregryz");
		} else {
			if (logged+were < capacity) {
				System.out.println("Zashli lydi");
				were=logged+were;
			} else
				System.out.println("Yje zagryjen");
		}
	}

	public void peopleWentOut(int out ) {
		if (were == 0) {
			System.out.println("Net lydei");
		} else
			were=were-out;
			System.out.println("Vishli lydi");
	}

}

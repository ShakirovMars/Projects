package Life;

public class Play {
	// Game play
	public void begin(OldGeneration oldGeneration, NewGeneration newGeneration,
			Rules rules, ForAutostop forAutostop) throws InterruptedException {
		// Check the conditions of repetition or cell extinction
		while (rules.repeat != true && oldGeneration.l != 0) {
			// A call to check the right
			rules.check(oldGeneration, newGeneration);
			// Change of generation
			rules.aNewGeneration(oldGeneration, newGeneration);
			System.out.println();
			Thread.sleep(1000);
			// Output
             oldGeneration.sysoPole();
			// Check coincidence generation
			rules.autostop(oldGeneration, newGeneration, forAutostop);
		}
		System.out.println();
		System.out.println("Autostop");
	}
}
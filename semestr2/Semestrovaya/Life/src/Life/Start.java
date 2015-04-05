package Life;

public class Start {
	public static void main(String args[]) throws InterruptedException {
		// Creating objects
		Play play = new Play();
		OldGeneration oldGeneration = new OldGeneration();
		NewGeneration newGeneration = new NewGeneration();
		Rules rules = new Rules();
		ForAutostop forAutostop = new ForAutostop();
		// Filling
		oldGeneration.input();
		// Creation of an additional array
		newGeneration.additionalArray(oldGeneration);
		// Preservation generation
		forAutostop.copy(oldGeneration);
		// Output
		oldGeneration.sysoPole();

		// Start the game
		play.begin(oldGeneration, newGeneration, rules, forAutostop);
	}
}

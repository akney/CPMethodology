package ney.dogdoor;

import java.util.HashSet;

public class BarkRecognizer {
	private DogDoor door;
	private HashSet<Bark> allowedBarks;

	public BarkRecognizer(DogDoor door) {
		this.door = door;
		allowedBarks = new HashSet<Bark>();
	}

	public void recognize(Bark bark) {
		System.out.println("   	BarkRecognizer: Heard a '" + bark + "'");
		if (allowedBarks.contains(bark)) {
			door.open();
		} else {
			System.out.println("Dog not allowed entry.");
		}

	}

	public void addBark(Bark bark) {
		allowedBarks.add(bark);
	}

	public void removeBark(Bark bark) {
		allowedBarks.remove(bark);
	}

}

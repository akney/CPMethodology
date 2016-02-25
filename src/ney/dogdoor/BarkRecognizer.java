package ney.dogdoor;

import java.util.HashSet;

public class BarkRecognizer {
	private DogDoor door;
	private HashSet<Bark> allowedBarks;

	/**
	 * Creates an instance of BarkRecognizer
	 * 
	 * @param door
	 *            takes in DogDoor which it will control
	 */
	public BarkRecognizer(DogDoor door) {
		this.door = door;
		allowedBarks = new HashSet<Bark>();
	}

	/**
	 * Recognizes if the bark is in the system and will be allowed entry
	 * 
	 * @param bark
	 *            takes in the allowed bark
	 */
	public void recognize(Bark bark) {
		System.out.println("BarkRecognizer: Heard a '" + bark.getSound() + "'");
		if (allowedBarks.contains(bark)) {
			door.open();
		} else {
			System.out.println("Dog not allowed entry.");
		}

	}

	/**
	 * adds an allowed bark
	 * 
	 * @param bark
	 *            takes in the bark
	 */
	public void addBark(Bark bark) {
		allowedBarks.add(bark);
	}

	/**
	 * removes an allowed bark
	 * 
	 * @param bark
	 *            takes in the bark it is looking to remove
	 */
	public void removeBark(Bark bark) {
		allowedBarks.remove(bark);
	}

}

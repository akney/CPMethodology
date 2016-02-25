package ney.dogdoor;

import java.util.HashSet;

public class PawRecognizer {
	private DogDoor door;
	private HashSet<Paw> allowedPaws;

	/**
	 * Creates an instance of PawRecognizer
	 * 
	 * @param door
	 *            takes in DogDoor which it will control
	 */
	public PawRecognizer(DogDoor door) {
		this.door = door;
		allowedPaws = new HashSet<Paw>();
	}

	/**
	 * Recognizes if the paw is in the system and will be allowed entry
	 * 
	 * @param paw
	 *            takes in the paw
	 */
	public void recognize(Paw paw) {
		System.out.println("PawRecognizer detects a paw...");
		if (allowedPaws.contains(paw)) {
			door.open();
		} else {
			System.out.println("This dog is not allowed entry.");
		}
	}

	/**
	 * Adds an allowed/recognized paw to the PawRecognizer
	 * 
	 * @param paw
	 *            takes in the new paw
	 */
	public void addPaw(Paw paw) {
		allowedPaws.add(paw);
	}

	/**
	 * Removes a paw if a particular dog is no longer wanted in the system
	 * 
	 * @param paw
	 *            takes in the paw that is to be removed
	 */
	public void removePaw(Paw paw) {
		allowedPaws.remove(paw);
	}
}

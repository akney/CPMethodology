package ney.dogdoor;

import java.util.HashSet;

public class DogRecognizer {
	private DogDoor dogDoor;
	private HashSet<Dog> allowedDogs;
	private PawRecognizer pawRecognizer;
	private BarkRecognizer barkRecognizer;

	/**
	 * DogRecognizer is meant to check if the dog coming in is allowed
	 * 
	 * @param dogDoor
	 */
	public DogRecognizer(DogDoor dogDoor) {
		this.dogDoor = dogDoor;
		pawRecognizer = new PawRecognizer(dogDoor);
		barkRecognizer = new BarkRecognizer(dogDoor);
	}

	public void recognizeWithBark(Bark bark) {
		barkRecognizer.recognize(bark);
	}

	public void recognizeWithPaw(Paw paw) {
		pawRecognizer.recognize(paw);
	}

	public void recognizeEnteringDog(Object o) {
		if (!(o instanceof Dog) || !allowedDogs.contains(o)) {
			dogDoor.close();
		}
	}

	public void addAllowedDog(Dog dog) {
		allowedDogs.add(dog);
		pawRecognizer.addPaw(dog.getPaw());
		barkRecognizer.addBark(dog.getBark());
	}

	public void removeAllowedDog(Dog dog) {
		allowedDogs.remove(dog);
		pawRecognizer.removePaw(dog.getPaw());
		barkRecognizer.removeBark(dog.getBark());
	}
}

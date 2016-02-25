package ney.dogdoorBook;

public class BarkRecognizer {
	private DogDoor door;
	private Bark allowedBark;

	public BarkRecognizer(DogDoor door, Bark bark) {
		this.door = door;
		allowedBark = bark;
	}

	public void recognize(Bark bark) {
		System.out.println("   	BarkRecognizer: Heard a '" + bark.getString() + "'");
		if (getAllowedBark().equals(bark)) {
			door.open();
		} else {
			System.out.println("Dog not allowed entry.");
		}

	}

	private Bark getAllowedBark() {
		return allowedBark;
	}
}

package ney.dogdoorBook;

public class Driver {

	public static void main(String[] args) {

		DogDoor door = new DogDoor();
		Bark allowedBark = new Bark("woof");
		BarkRecognizer recognizer = new BarkRecognizer(door, allowedBark);
		DoorRemote remote = new DoorRemote(door);

		System.out.println("Opening the door with the remote...");
		remote.pressButton();
		System.out.println("Closing the door with the remote...");
		remote.pressButton();
		System.out.println("Rover barks arf...");
		Bark roverBark = new Bark("arf");
		recognizer.recognize(roverBark);
		System.out.println("Fido barks woof...");
		Bark fidoBark = new Bark("woof");
		recognizer.recognize(fidoBark);

	}

}

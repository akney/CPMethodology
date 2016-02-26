package ney.dogdoor;

public class Driver {
	public static void main(String[] args) {

		DogDoor dogDoor = new DogDoor();
		Dog fifi = new Dog(new Paw(1), new Bark("Woof"));
		Dog louis = new Dog(new Paw(3), new Bark("Arf"));
		Dog rover = new Dog(new Paw(2), new Bark("Ruff"));

		DogRecognizer recognizer = new DogRecognizer(dogDoor);
		recognizer.addAllowedDog(rover);
		recognizer.addAllowedDog(fifi);

		DogDoorRemote remote = new DogDoorRemote(dogDoor);

		System.out.println("Using the remote.");
		remote.openButton();

		System.out.println("\nRover entering the dog door.");
		recognizer.recognizeEnteringDog(rover);

		System.out.println("\nUsing the remote.");
		remote.closeButton();

		System.out.println("\nUsing the remote.");
		remote.automaticCloseButton();

		System.out.println("\nFifi barks at the door.");
		recognizer.recognizeWithBark(fifi.getBark());

		System.out.println("\nFifi entering the door.");
		recognizer.recognizeEnteringDog(fifi);

		System.out.println("\nLouis tries entering too.");
		recognizer.recognizeEnteringDog(louis);

		System.out.println("\nLouis barks at the door.");
		recognizer.recognizeWithBark(louis.getBark());

		System.out.println("\nRover scratches the door.");
		recognizer.recognizeWithPaw(rover.getPaw());

		System.out.println("\nRover goes through the door.");
		recognizer.recognizeEnteringDog(rover);

		Cat cat = new Cat();
		System.out.println("\nA cat tries to enter.");
		recognizer.recognizeEnteringDog(cat);

		System.out.println("\n\nNow testing code box.");
		DogDoor dogDoor2 = new DogDoor();

		CodeBox codeBox = new CodeBox(3442, dogDoor);
		System.out.println("New code box with dogDoor in it.");
		System.out.println("Adding dogDoor2 to the code box.");
		codeBox.addDogDoor(dogDoor2);
		System.out.println("Closing all dog doors, entering right code.");
		codeBox.closeAll(3442);
		System.out.println("Opening all dog doors, with wrong code.");
		codeBox.openAll(4442);
		System.out.println("Opening all dog doors with right code.");
		codeBox.openAll(3442);

	}

}

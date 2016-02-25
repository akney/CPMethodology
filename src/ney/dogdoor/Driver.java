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
	}

}

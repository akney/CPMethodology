package ney.dogdoor;

import java.util.Timer;
import java.util.TimerTask;

public class Driver {
	public static void main(String[] args) {
		final Timer timer = new Timer();
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

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("5 seconds have passed");
				timer.cancel();
			}
		}, 5000);

		System.out.println("Rover entering the dog door.");
		recognizer.recognizeEnteringDog(rover);

		System.out.println("Using the remote.");
		remote.closeButton();

		System.out.println("Using the remote.");
		remote.automaticCloseButton();

	}

}

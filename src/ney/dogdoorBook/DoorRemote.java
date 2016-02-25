package ney.dogdoorBook;

public class DoorRemote {
	private DogDoor door;

	public DoorRemote(DogDoor door) {
		this.door = door;
	}

	public void pressButton() {
		System.out.println("Pressing the remote control button...");
		if (door.isOpen()) {
			door.close();
		} else {
			door.open();
		}

	}
}

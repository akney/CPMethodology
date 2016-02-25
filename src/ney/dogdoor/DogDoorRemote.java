package ney.dogdoor;

public class DogDoorRemote {
	private DogDoor dogDoor;

	public DogDoorRemote(DogDoor dogDoor) {
		this.dogDoor = dogDoor;
	}

	public void open() {
		System.out.println("The dog door is open.");
		dogDoor.setOpen(true);

	}

	public void close() {
		System.out.println("The dog door is closed.");
		dogDoor.setOpen(false);
	}

}

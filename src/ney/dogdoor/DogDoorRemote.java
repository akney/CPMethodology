package ney.dogdoor;

public class DogDoorRemote {
	private DogDoor dogDoor;

	/**
	 * Creates an instance of DogDoor
	 * 
	 * @param dogDoor
	 *            takes in DogDoor that the remote will be connected to
	 */
	public DogDoorRemote(DogDoor dogDoor) {
		this.dogDoor = dogDoor;
	}

	/**
	 * Opens the DogDoor
	 */
	public void openButton() {
		System.out.println("Pressing open button.");
		dogDoor.open();
	}

	/**
	 * Closes the DogDoor
	 */
	public void closeButton() {
		System.out.println("Pressing closed button.");
		dogDoor.close();
	}

	/**
	 * Changes automatic close options from the remote
	 */
	public void automaticCloseButton() {
		System.out.println("Pressing Automatic Close Button");
		if (dogDoor.isAutomaticClosing()) {
			dogDoor.setAutomaticClosing(false);
		} else {
			dogDoor.setAutomaticClosing(true);
		}
	}

}

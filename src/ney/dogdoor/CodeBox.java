package ney.dogdoor;

public class CodeBox {
	private int code;
	private DogDoor[] dogDoors = new DogDoor[5];
	private int counter;

	public CodeBox(int code, DogDoor dogDoor) {
		this.code = code;
		dogDoors[0] = dogDoor;
		counter = 1;
	}

	public void openAll(int attemptedCode) {
		if (attemptedCode == code) {
			System.out.println("Closing all doors.");
			for (int i = 0; i < counter; i++) {
				dogDoors[i].open();
			}
		}
	}

	public void closeAll(int attemptedCode) {
		if (attemptedCode == code) {
			System.out.println("Closing all doors.");
			for (int i = 0; i < counter; i++) {
				dogDoors[i].close();
			}
		}
	}
}

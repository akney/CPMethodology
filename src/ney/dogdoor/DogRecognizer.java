package ney.dogdoor;

public class DogRecognizer {
	private DogDoor dogDoor;

	public DogRecognizer(DogDoor dogDoor) {
		this.dogDoor = dogDoor;
	}

	public void recognize(Object o) {
		if (!(o instanceof Dog)) {
			dogDoor.close();
		}
	}
}

package ney.dogdoor;

import org.junit.Assert;
import org.junit.Test;

public class TestDogDoorRemote {

	@Test
	public void testOpen() {
		DogDoor dogDoor = new DogDoor();
		DogDoorRemote ddremote = new DogDoorRemote(dogDoor);
		ddremote.open();
		Assert.assertTrue(dogDoor.isOpen());
	}

	@Test
	public void testClose() {
		DogDoor dogDoor = new DogDoor();
		DogDoorRemote ddremote = new DogDoorRemote(dogDoor);
		ddremote.open(); // I first opened it because the default of door is
							// close
		ddremote.close();
		Assert.assertFalse(dogDoor.isOpen());
	}
}

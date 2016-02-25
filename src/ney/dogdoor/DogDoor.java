package ney.dogdoor;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
	private boolean open;

	public DogDoor() {
		open = false;

	}

	public void open() {
		System.out.println("The dog door opened.");
		open = true;
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				close();
				timer.cancel();
			}
		}, 5000);

	}

	public void close() {
		System.out.println("the dog door closed.");
		open = false;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}

package ney.observer;

public class Client implements IObserver {

	@Override
	public void update(Job job) {
		processUpdate(job);

	}

	private void processUpdate(Job job) {
		// do something with the job

	}

}

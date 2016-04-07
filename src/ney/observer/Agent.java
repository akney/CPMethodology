package ney.observer;

import java.util.ArrayList;

public class Agent implements ISubject {
	ArrayList<IObserver> contacts;

	@Override
	public void registerObserver(IObserver contact) {
		contacts.add(contact);
	}

	@Override
	public void removeObserver(IObserver contact) {
		contacts.remove(contact);
	}

	@Override
	public void notifyObserver(Job job) {
		for (IObserver contact : contacts) {
			contact.update(job);
		}

	}

}

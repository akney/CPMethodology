package ney.observer;

public interface ISubject {
	void registerObserver(IObserver o);

	void removeObserver(IObserver o);

	void notifyObserver(Job job);
}

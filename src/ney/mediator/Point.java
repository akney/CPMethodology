package ney.mediator;

public class Point implements IPoint {

	@Override
	public void recieveMessage(Message message) {
		doSomethingWithMessage(message);

	}

	@Override
	public void sendMessage(Message message, IPoint point) {
		// TODO Auto-generated method stub

	}

	public void doSomethingWithMessage(Message message) {

	}

}

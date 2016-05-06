package ney.mediator;

public class Router implements IRouter {

	@Override
	public void sendMessage(Message message, IPoint point) {
		point.recieveMessage(message);

	}

}

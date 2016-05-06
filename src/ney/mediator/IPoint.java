package ney.mediator;

public interface IPoint {
	public void recieveMessage(Message message);

	public void sendMessage(Message message, IPoint point);

}

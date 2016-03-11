package ney.callcenter;

public abstract class Employee {
	private int rank;
	private int id;
	private static int idgenerator = 1;
	private boolean free;
	private CallHandler callHandler;
	private Call callBeingHandled;

	public Employee(String name, String address, int rank) {
		this.rank = rank;
		this.id = idgenerator++;
	}

	public int getRank() {
		return rank;
	}

	public int getId() {
		return id;
	}

	public boolean isFree() {
		return free;
	}

	public void receiveCall(Call call) {
		free = false;
		callBeingHandled = call;
	}

	public void handledCall() {
		callBeingHandled.disconnect();
		free = true;

	}

	public void deferCall() {
		callBeingHandled.setRank(callBeingHandled.getRank() + 1);
		free = true;

		callHandler.dispatchCall(callBeingHandled);
		callHandler.getNextCall(this);
	}

}

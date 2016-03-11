package ney.callcenter;

public class Call {
	private int rank = 0;

	public Call(int rank) {

	}

	public void reply(String message) {
		// plays recorded message to the customer
	}

	public void disconnect() {
		reply("Thank you for calling");
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}

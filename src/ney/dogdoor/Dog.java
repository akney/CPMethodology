package ney.dogdoor;

public class Dog {
	private Paw paw;
	private Bark bark;

	public Dog(Paw paw, Bark bark) {
		this.paw = paw;
		this.bark = bark;
	}

	public Paw getPaw() {
		return paw;
	}

	public Bark getBark() {
		return bark;
	}

	public void setPaw(Paw paw) {
		this.paw = paw;
	}

	public void setBark(Bark bark) {
		this.bark = bark;
	}

}

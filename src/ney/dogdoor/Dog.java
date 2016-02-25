package ney.dogdoor;

public class Dog {
	private Paw paw;
	private Bark bark;

	public Dog(Paw paw, Bark bark) {
		this.paw = paw;
		this.bark = bark;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Dog other = (Dog) obj;
		if (bark == null) {
			if (other.bark != null) {
				return false;
			}
		} else if (!bark.equals(other.bark)) {
			return false;
		}
		if (paw == null) {
			if (other.paw != null) {
				return false;
			}
		} else if (!paw.equals(other.paw)) {
			return false;
		}
		return true;
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

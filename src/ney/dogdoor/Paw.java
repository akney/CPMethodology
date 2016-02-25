package ney.dogdoor;

public class Paw {
	int pawNum;

	public Paw(int pawNum) {
		this.pawNum = pawNum;
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
		Paw other = (Paw) obj;
		if (pawNum != other.pawNum) {
			return false;
		}
		return true;
	}
}

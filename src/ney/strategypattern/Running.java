package ney.strategypattern;

public class Running implements ITravel {
	private double speedperInterval = 5;

	@Override
	public double move(int intervals) {

		return speedperInterval * intervals;
	}

	public double getSpeedperInterval() {
		return speedperInterval;
	}

	public void setSpeedperInterval(double speedperInterval) {
		this.speedperInterval = speedperInterval;
	}

}

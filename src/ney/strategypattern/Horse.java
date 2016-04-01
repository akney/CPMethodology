package ney.strategypattern;

public class Horse implements ITravel {
	private double speedperInterval = 15;

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

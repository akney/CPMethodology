package ney.AbstractVsInterface;

import java.awt.Color;

public class RandomObject implements Colorful {
	Color color;

	public RandomObject() {

	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

}

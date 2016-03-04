package ney.AbstractVsInterface;

import java.awt.Color;

public class Triangle extends Shape implements Colorful {
	Color color;

	public Triangle(double height, double base) {
		super(height, base, 3);

	}

	@Override
	public double calculateArea() {

		return height * width / 2;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public Color getColor() {

		return color;
	}

}

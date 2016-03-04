package ney.AbstractVsInterface;

public abstract class Shape {
	double height;
	double width;
	int numSides;

	public Shape(double height, double width, int numSides) {
		this.height = height;
		this.width = width;
		this.numSides = numSides;
	}

	public abstract double calculateArea();

}

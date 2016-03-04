package ney.AbstractVsInterface;

import java.awt.Color;

public class AbstractVsInterfaceMain {

	public static void main(String[] args) {
		Triangle tri = new Triangle(8, 3.5);
		tri.setColor(Color.BLUE);

		RandomObject rand = new RandomObject();
		rand.setColor(Color.RED);

		System.out.println("This triangle's color is " + tri.getColor().toString());
		System.out.println("This random objects color is" + rand.getColor().toString());
	}

}

package ney.strategypattern;

public class Sword implements IWeapon {
	private int damageAmount = 10;

	@Override
	public int doesDamage() {

		return damageAmount;
	}

}

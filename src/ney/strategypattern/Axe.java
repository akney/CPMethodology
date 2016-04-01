package ney.strategypattern;

public class Axe implements IWeapon {
	private int damageAmount = 5;

	@Override
	public int doesDamage() {
		return damageAmount;
	}

}

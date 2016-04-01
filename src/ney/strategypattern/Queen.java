package ney.strategypattern;

public class Queen implements ICharacter {
	private ITravel modeofTransportaion;

	@Override
	public int fight(IWeapon weapon) {

		return weapon.doesDamage();
	}

}

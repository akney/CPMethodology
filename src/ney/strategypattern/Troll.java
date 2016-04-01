package ney.strategypattern;

public class Troll implements ICharacter {
	private ITravel modeofTransportaion;

	@Override
	public int fight(IWeapon weapon) {

		return weapon.doesDamage();
	}

}

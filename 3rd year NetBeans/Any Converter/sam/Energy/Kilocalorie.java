package com.samasend.types.Energy;

/**
 *
 * @author SamAsEnd
 */
public class Kilocalorie implements Energy{

	private double value;

	public Kilocalorie(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toBritishThermalUnit() {
		return value;
	}


	@Override
	public double toCalorie() {
		return value;
	}


	@Override
	public double toElectronVolts() {
		return value;
	}


	@Override
	public double toFootPound() {
		return value;
	}


	@Override
	public double toJoule() {
		return value;
	}


	@Override
	public double toKilocalorie() {
		return value;
	}


	@Override
	public double toKilojoule() {
		return value;
	}

}

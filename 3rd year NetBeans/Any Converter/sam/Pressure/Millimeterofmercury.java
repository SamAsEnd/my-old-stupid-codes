package com.samasend.types.Pressure;

/**
 *
 * @author SamAsEnd
 */
public class Millimeterofmercury implements Pressure{

	private double value;

	public Millimeterofmercury(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toAtmosphere() {
		return value;
	}


	@Override
	public double toBar() {
		return value;
	}


	@Override
	public double toKiloPascal() {
		return value;
	}


	@Override
	public double toMillimeterofmercury() {
		return value;
	}


	@Override
	public double toPascal() {
		return value;
	}


	@Override
	public double toPoundperSquareInchPSI() {
		return value;
	}

}

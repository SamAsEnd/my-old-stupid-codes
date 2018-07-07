package com.samasend.types.Power;

/**
 *
 * @author SamAsEnd
 */
public class FootPoundminute implements Power{

	private double value;

	public FootPoundminute(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toBTUminute() {
		return value;
	}


	@Override
	public double toFootPoundminute() {
		return value;
	}


	@Override
	public double toHorsepower() {
		return value;
	}


	@Override
	public double toKilowatt() {
		return value;
	}


	@Override
	public double toWatt() {
		return value;
	}

}

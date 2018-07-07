package com.samasend.types.Power;

/**
 *
 * @author SamAsEnd
 */
public class BTUminute implements Power{

	private double value;

	public BTUminute(double value) throws Exception {
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

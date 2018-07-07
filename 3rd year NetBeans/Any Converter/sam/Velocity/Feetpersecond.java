package com.samasend.types.Velocity;

/**
 *
 * @author SamAsEnd
 */
public class Feetpersecond implements Velocity{

	private double value;

	public Feetpersecond(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toCentimeterpersecond() {
		return value;
	}


	@Override
	public double toFeetpersecond() {
		return value;
	}


	@Override
	public double toKilometerpersecond() {
		return value;
	}


	@Override
	public double toKnots() {
		return value;
	}


	@Override
	public double toMeterpersecond() {
		return value;
	}


	@Override
	public double toMilepersecond() {
		return value;
	}

}

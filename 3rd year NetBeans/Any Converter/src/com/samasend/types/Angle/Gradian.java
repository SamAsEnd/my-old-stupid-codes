package com.samasend.types.Angle;

/**
 *
 * @author SamAsEnd
 */
public class Gradian implements Angle{

	private double value;

	public Gradian(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toDegree() {
		return value * 0.9;
	}


	@Override
	public double toGradian() {
		return value;
	}


	@Override
	public double toRadian() {
		return value * 0.01570796326794897;
	}

}

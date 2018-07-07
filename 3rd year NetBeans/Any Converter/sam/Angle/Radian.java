package com.samasend.types.Angle;

/**
 *
 * @author SamAsEnd
 */
public class Radian implements Angle{

	private double value;

	public Radian(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toDegree() {
		return value;
	}


	@Override
	public double toGradian() {
		return value;
	}


	@Override
	public double toRadian() {
		return value;
	}

}

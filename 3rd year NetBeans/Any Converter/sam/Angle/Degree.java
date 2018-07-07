package com.samasend.types.Angle;

/**
 *
 * @author SamAsEnd
 */
public class Degree implements Angle{

	private double value;

	public Degree(double value) throws Exception {
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

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
		return value * 1.111111111111111;
	}


	@Override
	public double toRadian() {
		return value * 0.01745329251994329;
	}

}

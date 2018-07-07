package com.samasend.types.Temperature;

/**
 *
 * @author SamAsEnd
 */
public class DegreesCelsius implements Temperature{

	private double value;

	public DegreesCelsius(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toDegreesCelsius() {
		return value;
	}


	@Override
	public double toDegreesFahrenheit() {
		return value;
	}


	@Override
	public double toKelvin() {
		return value;
	}

}

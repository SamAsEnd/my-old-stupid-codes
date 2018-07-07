package com.samasend.types.Temperature;

/**
 *
 * @author SamAsEnd
 */
public class DegreesFahrenheit implements Temperature{

	private double value;

	public DegreesFahrenheit(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toDegreesCelsius() {
		return (value - 32) * 5.0/9;
	}


	@Override
	public double toDegreesFahrenheit() {
		return value;
	}


	@Override
	public double toKelvin() {
            return ((value - 32) * 5.0/9) + 273.25;
	}

}

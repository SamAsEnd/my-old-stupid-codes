package com.samasend.types.Temperature;

/**
 *
 * @author SamAsEnd
 */
public class Kelvin implements Temperature{

	private double value;

	public Kelvin(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toDegreesCelsius() {
		return value - 273.25;
	}


	@Override
	public double toDegreesFahrenheit() {
            return ((value - 273.25) - 32) * 5.0/9;
	}


	@Override
	public double toKelvin() {
		return value;
	}

}

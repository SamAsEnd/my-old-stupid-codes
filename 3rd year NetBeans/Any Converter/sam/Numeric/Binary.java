package com.samasend.types.Numeric;

/**
 *
 * @author SamAsEnd
 */
public class Binary implements Numeric{

	private double value;

	public Binary(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toBinary() {
		return value;
	}


	@Override
	public double toHexaDecimal() {
		return value;
	}


	@Override
	public double toDecimal() {
		return value;
	}

}

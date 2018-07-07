package com.samasend.types.Numeric;

/**
 *
 * @author SamAsEnd
 */
public class HexaDecimal implements Numeric{

	private double value;

	public HexaDecimal(double value) throws Exception {
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

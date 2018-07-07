package com.samasend.types.Volume;

/**
 *
 * @author SamAsEnd
 */
public class FluidOunceUK implements Volume{

	private double value;

	public FluidOunceUK(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toCubicCentimeter() {
		return value;
	}


	@Override
	public double toCubicFeet() {
		return value;
	}


	@Override
	public double toCubicInch() {
		return value;
	}


	@Override
	public double toCubicMeter() {
		return value;
	}


	@Override
	public double toCubicYard() {
		return value;
	}


	@Override
	public double toFluidOunceUK() {
		return value;
	}


	@Override
	public double toFluidOunceUS() {
		return value;
	}


	@Override
	public double toGallonUK() {
		return value;
	}


	@Override
	public double toGallonUS() {
		return value;
	}


	@Override
	public double toLiter() {
		return value;
	}


	@Override
	public double toPintUK() {
		return value;
	}


	@Override
	public double toPintUS() {
		return value;
	}


	@Override
	public double toQuartUK() {
		return value;
	}


	@Override
	public double toQuartUS() {
		return value;
	}

}

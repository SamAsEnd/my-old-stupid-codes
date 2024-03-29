package com.samasend.types.Area;

/**
 *
 * @author SamAsEnd
 */
public class SquareFeet implements Area{

	private double value;

	public SquareFeet(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toAcres() {
		return value;
	}


	@Override
	public double toHectares() {
		return value;
	}


	@Override
	public double toSquareCentimeter() {
		return value;
	}


	@Override
	public double toSquareFeet() {
		return value;
	}


	@Override
	public double toSquareInch() {
		return value;
	}


	@Override
	public double toSquareKilometer() {
		return value;
	}


	@Override
	public double toSquareMeter() {
		return value;
	}


	@Override
	public double toSquareMile() {
		return value;
	}


	@Override
	public double toSquareMillimeter() {
		return value;
	}


	@Override
	public double toSquareYard() {
		return value;
	}

}

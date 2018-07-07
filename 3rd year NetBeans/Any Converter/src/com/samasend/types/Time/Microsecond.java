package com.samasend.types.Time;

/**
 *
 * @author SamAsEnd
 */
public class Microsecond implements Time{

	private double value;

	public Microsecond(double value) throws Exception {
		this.value = value;
	}


	@Override
	public double toDay() {
		return value;
	}


	@Override
	public double toHour() {
		return value;
	}


	@Override
	public double toMicrosecond() {
		return value;
	}


	@Override
	public double toMillisecond() {
		return value;
	}


	@Override
	public double toMinute() {
		return value;
	}


	@Override
	public double toMonth() {
		return value;
	}


	@Override
	public double toSecond() {
		return value;
	}


	@Override
	public double toWeek() {
		return value;
	}


	@Override
	public double toYear() {
		return value;
	}

}

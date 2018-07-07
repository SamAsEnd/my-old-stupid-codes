package com.samasend.types.Time;

/**
 *
 * @author SamAsEnd
 */
public class Day implements Time {

    private double value;

    public Day(double value) throws Exception {
        this.value = value;
    }

    @Override
    public double toDay() {
        return value;
    }

    @Override
    public double toHour() {
        return value * 24;
    }

    @Override
    public double toMicrosecond() {
        return toSecond() * 1_000_000;
    }

    @Override
    public double toMillisecond() {
        return toSecond() * 100;
    }

    @Override
    public double toMinute() {
        return toHour() * 60;
    }

    @Override
    public double toMonth() {
        return value / 30;
    }

    @Override
    public double toSecond() {
        return toMinute() * 60;
    }

    @Override
    public double toWeek() {
        return value / 7;
    }

    @Override
    public double toYear() {
        return value / 365.25;
    }
}

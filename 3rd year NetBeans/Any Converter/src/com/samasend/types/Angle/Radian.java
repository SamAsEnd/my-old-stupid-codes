package com.samasend.types.Angle;

/**
 *
 * @author SamAsEnd
 */
public class Radian implements Angle {

    private double value;

    public Radian(double value) throws Exception {
        this.value = value;
    }

    @Override
    public double toDegree() {
        return value * 57.29577951308233;
    }

    @Override
    public double toGradian() {
        return value * 63.66197723675814;
    }

    @Override
    public double toRadian() {
        return value;
    }
}

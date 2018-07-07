package com.sam.Converter;
/**
 *
 * @author Sam As End
 */
public class Kelvin extends Tempeture implements TempretureInterface {

    public Kelvin() {
        super(0.0f,"Kelvin");
    }

    public Kelvin(float value) {
        super(value,"Kelvin");
    }
    
    @Override
    public float toKelvin() {
        return value;
    }

    @Override
    public float toCelsius() {
        return (float) (value - 273.25);
    }

    @Override
    public float toFahrenheit() {
        return (float)((9.0f/5.0f)*(value - 273.25)+32.0f);
    }

}
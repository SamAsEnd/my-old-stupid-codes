package com.sam.Converter;
/**
 * @author <b>Sam As End</b>
 */
public class Celsius extends Tempeture implements TempretureInterface {

    public Celsius() {
        super(0.0f,"Celsius");
    }

    public Celsius(float value) {
        super(value,"Celsius");
    }
    
    @Override
    public float toKelvin() {
        return (float) value + 273.25f;
    }

    @Override
    public float toCelsius() {
        return value;
    }

    @Override
    public float toFahrenheit() {
        return (float)((9.0f/5.0f)*value+32.0f);
    }
    
}

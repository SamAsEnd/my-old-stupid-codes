/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.Converter;

/**
 *
 * @author Sam As End
 */
public class Fahrenheit extends Tempeture implements TempretureInterface{

    public Fahrenheit() {
        super(0.0f,"Fahrenheit");
    }

    public Fahrenheit(float value) {
        super(value,"Fahrenheit");
    }

    @Override
    public float toKelvin() {
         return (float)((5.0f/9.0f)*(value-32.0f) + 273.25f);
    }

    @Override
    public float toCelsius() {
        return (float)(5.0f/9.0f)*(value-32.0f);
    }

    @Override
    public float toFahrenheit() {
        return value;
    }
    
}

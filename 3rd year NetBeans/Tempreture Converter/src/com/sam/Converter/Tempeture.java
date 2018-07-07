package com.sam.Converter;

/**
 *
 * @author Sam As End
 */
public abstract class Tempeture {
    
    protected float value;
    protected String type; 
    /**
     * This constructor accept two float nd String parameter to set the value nd type
     */
    public Tempeture(float value, String type) {
        this.value = value;
        this.type = type;
    }
    /**
     * @return the value
     */
    public float getValue() {
        return this.value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    public static String toString(float v,Tempeture t) {
        return v + " " + '\u00B0' +t.type.toUpperCase().charAt(0);
    }
    
}

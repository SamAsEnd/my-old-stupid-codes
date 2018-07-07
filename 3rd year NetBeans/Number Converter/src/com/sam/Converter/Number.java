package com.sam.Converter;

/**
 *
 * @author Sam As End
 */
public class Number implements com.sam.Converter.NumberInterface{
    
    protected long value;
    /**
     * This constructor accept two float nd String parameter to set the value nd type
     */
    public Number(long value) {
        this.value = value;
    }

    public Number() {
        this(0L);
    }
    /**
     * @return the value
     */
    public long getValue() {
        return this.value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(long value) {
        this.value = value;
    }

    public static String toString(Number t) {
        return Long.toString(t.value).toUpperCase();
    }
    
    @Override
    public String toString() {
        return Long.toString(this.value).toUpperCase();
    }

    @Override
    public String toBinary() {
        return Long.toBinaryString(value).toUpperCase();
    }

    @Override
    public String toHexaDecimal() {
        return Long.toHexString(value).toUpperCase();
    }

    @Override
    public String toDecimal() {
        return Long.toString(value).toUpperCase();
    }
    
    
}

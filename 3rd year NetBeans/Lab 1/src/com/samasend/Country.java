package com.samasend;

import java.io.InputStream;
import javax.swing.ImageIcon;

public class Country {

    private String code;
    private String name_en;
    private String name_am;
    private String currencyCode;
    private long population;
    private String capital;
    private String continent;
    private double areaInSqKm;
    private ImageIcon icon;
    private InputStream audio;

    public Country(String code, String name_am) {
        this.code = code;
        this.name_am = name_am;
    }

    @Override
    public String toString() {
        return name_am;
    }

    public double getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(double areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getName_am() {
        return name_am;
    }

    public void setName_am(String name_am) {
        this.name_am = name_am;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    
    public InputStream getAudio() {
        return audio;
    }

    public void setAudio(InputStream audio) {
        this.audio = audio;
    }
    
}

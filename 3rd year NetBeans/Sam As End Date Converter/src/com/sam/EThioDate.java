/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import java.util.Locale;

/**
 *
 * @author Sam As End
 */
public class EThioDate {

    /**
     * Day of the week<br /> <b>1 - 30</b>
     */
    private int day;
    /**
     * Month of the year<br /> <b>1 - 13</b>
     */
    private int month;
    /**
     * Year<br /> <b>negative for B.C </b>
     */
    private int year;
    //<editor-fold defaultstate="collapsed" desc="Week Name">
    public final static int EHUD = 0;
    public final static int SEGO = 1;
    public final static int MAKSEGO = 2;
    public final static int EROB = 3;
    public final static int HAMUS = 4;
    public final static int ARB = 5;
    public final static int KIDAME = 6;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Month Name">
    public final static int MESKEREM = 1;
    public final static int TIKIMT = 2;
    public final static int HIDAR = 3;
    public final static int TAHISAS = 4;
    public final static int TIR = 5;
    public final static int YEKATIT = 6;
    public final static int MEGABIT = 7;
    public final static int MIYAZIYA = 8;
    public final static int GINIBOT = 9;
    public final static int SENE = 10;
    public final static int HAMLE = 11;
    public final static int NEHASE = 12;
    public final static int PAGUME = 13;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructers">
    public EThioDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public EThioDate() {
        this(0, 0, 0);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter & Getter">
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //</editor-fold>
    public static final boolean AMHARIC = true;
    public static final boolean ENGLISH = true;

    //<editor-fold defaultstate="collapsed" desc="FUNCTIONALITY">
    public boolean isLeapYear() {
        return year > 0 ? (year % 4 == 3) : (Math.abs(year) % 4 == 1);
    }

    public int getWeekDay() {
        int d = (int) (((year - 1) * 365.25) + ((month - 1) * 30) + day);
        System.out.println(d);
        return (d % 7) + 2;
    }

    public static String weekKayToString(int weekDay, boolean b) throws Exception {
        String str;
        if (b) {
            switch (weekDay) {
                case 0:
                    str = "Ehud";
                    break;
                case 1:
                    str = "Sego";
                    break;
                case 2:
                    str = "Maksego";
                    break;
                case 3:
                    str = "Erob";
                    break;
                case 4:
                    str = "Hamus";
                    break;
                case 5:
                    str = "Arb";
                    break;
                case 6:
                    str = "Kidame";
                    break;
            }
        } else {
            switch (weekDay) {
                case 0:
                    str = "Ehud";
                    break;
                case 1:
                    str = "Sego";
                    break;
                case 2:
                    str = "Maksego";
                    break;
                case 3:
                    str = "Erob";
                    break;
                case 4:
                    str = "Hamus";
                    break;
                case 5:
                    str = "Arb";
                    break;
                case 6:
                    str = "Kidame";
                    break;
            }
        }
    }
    //</editor-fold>
}

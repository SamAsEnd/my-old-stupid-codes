package com.samasend;

import java.time.LocalDate;

public class EthCal {
    
    public static final int JD_EPOCH_OFFSET_GREGORIAN = 1721426;
    
    private static int NUMBER_OF_MONTH = 12;
    private static int[] DAYS_IN_MONTH = {
        0,
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };
    
    private int day;
    private int month;
    private int year;
    private Era era;
    
    private long jdn;
    private boolean set;

    public EthCal(LocalDate date) {
        setDate(date);
    }

    public EthCal() {
        this(LocalDate.now());
    }
    
    public EthCal(int day, int month, int year, Era era) {
        if (year < 0 && Era.AMETE_MIHRET.equals(era)) {
            throw new IllegalArgumentException("year can't be -ve and the era Era.AMETE_MIHRET");
        }
        this.day = day;
        this.month = month;
        this.year = year;
        this.era = era;
        set = true;
    }
    
    public EthCal(int day, int month, int year) {
        this(day, month, Math.abs(year),
                (year >= 0) ? Era.AMETE_MIHRET : Era.AMETE_ALEM
        );
        calculateJDN();
    }
    
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
    
    public Era getEra() {
        return era;
    }
    
    public void setEra(Era era) {
        this.era = era;
    }
    
    public long getJdn() {
        return jdn;
    }
    
    public void setJdn(long jdn) {
        this.jdn = jdn;
    }
    
    public boolean isSet() {
        return set;
    }
    
    private void calculateJDN() {
        jdn = (eraToValue(era) + 365)
                + 365 * (year - 1)
                + (year / 4)
                + 30 * month
                + day - 31;
    }
    
    public LocalDate getDate() {
        long r2000 = (jdn - JD_EPOCH_OFFSET_GREGORIAN) % 730485;
        long r400 = (jdn - JD_EPOCH_OFFSET_GREGORIAN) % 146097;
        long r100 = r400 % 36524;
        long r4 = r100 % 1461;

        long n = (r4 % 365) + 365 * (r4 / 1460);
        long s = (r4 / 1095);

        long aprime = 400 * ((jdn - JD_EPOCH_OFFSET_GREGORIAN) / 146097)
                + 100 * (r400 / 36524)
                + 4 * (r100 / 1461)
                + (r4 / 365)
                - (r4 / 1460)
                - (r2000 / 730484);
        long year = aprime + 1;
        long t = ((364 + s - n) / 306);
        long month = t * ((n / 31) + 1) + (1 - t) * (((5 * (n - s) + 13) / 153) + 1);
        
        n += 1 - (r2000 / 730484);
        long day = n;
        if ((r100 == 0) && (n == 0) && (r400 != 0)) {
            month = 12;
            day = 31;
        } else {
            DAYS_IN_MONTH[2] = (isGregorianLeap(year)) ? 29 : 28;
            for (int i = 1; i <= NUMBER_OF_MONTH; ++i) {
                if (n <= DAYS_IN_MONTH[i]) {
                    day = n;
                    break;
                }
                n -= DAYS_IN_MONTH[i];
            }
        }
        return LocalDate.of((int)year,(int)month,(int)day);
//        return LocalDate.ofEpochDay((long) ((jdn - 2440587.5)));
    }
    
    private boolean isGregorianLeap(long year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    private void setDate(LocalDate date) {
        int _year = date.getYear();
        int _month = date.getMonthValue();
        int _day = date.getDayOfMonth();
        
        long s = (_year / 4)
                - ((_year - 1) / 4)
                - (_year / 100)
                + ((_year - 1) / 100)
                + (_year / 400)
                - (_year - 1 / 400);

        long t = ((14 - _month) / 12);

        long n = 31 * t * (_month - 1)
                + (1 - t) * (59 + s + 30 * (_month - 3) + ((3 * _month - 7) / 5))
                + _day - 1;

        long j = JD_EPOCH_OFFSET_GREGORIAN
                + 365 * (_year - 1)
                + ((_year - 1)/ 4)
                - ((_year - 1)/ 100)
                + ((_year - 1)/ 400)
                + n;

        jdn = j;
        
        jdnToEthiopic();
    }
    
    public void jdnToEthiopic() {
        long r = ((jdn - eraToValue(era)) % 1461);
        long n = (r % 365) + 365 * (r / 1460);

        year = (int) (4 * ((jdn - eraToValue(era)) / 1461)
                + (r / 365)
                - (r / 1460));
        month = (int) ((n / 30) + 1);
        day = (int) ((n % 30) + 1);
    }
    
    public enum Era {
        AMETE_ALEM,
        AMETE_MIHRET
    };
    
    private long eraToValue(Era era) {
        if (Era.AMETE_ALEM.equals(era)) {
            return -285019;
        } else {
            return 1723856;
        }
    }

    @Override
    public String toString() {
        return EthiopianDateFormater.format(this);
    }
    
    
}

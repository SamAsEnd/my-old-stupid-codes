package com.samasend;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ReminderTime {

    private String name;
    private Calendar calendar;

    public ReminderTime(String name,int year, int month, int day, int hour, int min, int sec) {
        this.name = name;
        calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, min, sec);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMin() {
        return calendar.get(Calendar.MINUTE);
    }

    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    public int getSec() {
        return calendar.get(Calendar.SECOND);
    }

    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setHour(int hour) {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
    }

    public void setMin(int min) {
        calendar.set(Calendar.MINUTE, min);
    }

    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month);
    }

    public void setSec(int sec) {
        calendar.set(Calendar.SECOND, sec);
    }

    @Override
    public boolean equals(Object obj) {
        Calendar c = (Calendar) obj;
        try {
            return (c.getTimeInMillis() == calendar.getTimeInMillis());
        } catch (Exception ex) {
            return false;
        }
    }
    public long getTimeRemening() {
        return (calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis());
    }
    
    public void beel() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, this, "BEEP", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

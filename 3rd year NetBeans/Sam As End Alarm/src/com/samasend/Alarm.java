/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.io.InputStream;
import java.util.Calendar;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;

/**
 *
 * @author SamAsEnd
 */
public class Alarm implements Runnable{
    
    private String title;
    private Calendar calendar;
    private InputStream inputStream;
    private AlarmDisplay display;
    
    public Alarm(String title, Calendar calendar, InputStream inputStream) {
        this.title = title;
        this.calendar = calendar;
        this.inputStream = inputStream;
    }
    
    @Override
    public void run() {
        while (calendar.after(Calendar.getInstance())) {            
            long timeInMillis = calendar.getTimeInMillis();
            long now = Calendar.getInstance().getTimeInMillis();
            long diff = timeInMillis - now;
            long waitingTime = 60 * 100;
            if(waitingTime > diff) {
                waitingTime -= 500;
            }
            try {
                System.out.println("waitingTime = " + waitingTime);
                synchronized (this) {
                    wait(waitingTime);
                }
            } catch (InterruptedException ex) {}
        }
        JOptionPane.showMessageDialog(null, "Time is now: " + title,"Alarm",JOptionPane.INFORMATION_MESSAGE);
        play(inputStream);
        stop(inputStream);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static void play(InputStream is) {
        AudioPlayer.player.start(is);
    }
    
    public static void stop(InputStream is) {
        AudioPlayer.player.stop(is);
    }
    
}

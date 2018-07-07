/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.util.Calendar;

/**
 *
 * @author SamAsEnd
 */
public class AlarmTest {
    
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 30);
        Alarm alarm = new Alarm("Sam As End", c, Class.class.getResourceAsStream("res/computer.au"));
        new Thread(alarm).start();
        System.out.println("exit");
    }

}

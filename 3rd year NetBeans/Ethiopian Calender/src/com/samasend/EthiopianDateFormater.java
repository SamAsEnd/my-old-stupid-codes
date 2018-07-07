/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

/**
 *
 * @author Sam As End
 */
class EthiopianDateFormater {

    public static String format(EthCal ec) {
        return dayToString(ec.getJdn()) + " " + (ec.getYear() % 4);
    }

    private static String dayToString(long d) {
        String[] dayName = {"እሑድ", "ሰኞ", "ማክሰኞ", "ረቡዕ", "ሓሙስ", "ዓርብ", "ቅዳሜ",};
        int dd = (int) ((d + 1) % 7);
        return dayName[dd];
    }
}

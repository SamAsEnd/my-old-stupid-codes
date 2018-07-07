
package com.zzz.old;

import com.samasend.EthiopianCalendar;

public class Test {

    public static void main(String[] args) {
        EthiopianCalendar ec = new EthiopianCalendar(1986, 3, 21);
        int[] ethiopicToGregorian = ec.ethiopicToGregorian();
        for (int i : ethiopicToGregorian) {
            System.out.print(i + " ");
        }
    }

}

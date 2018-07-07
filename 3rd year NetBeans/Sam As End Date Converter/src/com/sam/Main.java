package com.sam;

/**
 *   Sam As End
 * 
 * @author Sam As End
 */
public class Main {

    public static void main(String[] args) {
        EThioDate x = new EThioDate(21, 3, 2005);
        
        System.out.println(x.getDayName());
        
        /*
         * for (int i = -20; i < 20; i++) {
            if(x.isLeapYear()){
                System.out.println(x.getYear()+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else {
                System.out.println(x.getYear()+"  ");
            }
            x.setYear(i);
        }
        */
        
    }
    
}

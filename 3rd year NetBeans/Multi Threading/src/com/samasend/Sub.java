package com.samasend;

/**
 *
 * @author SamAsEnd
 */
public class Sub extends Sup{

    public Sub() {
        System.out.println("Sub()");
    }
    
    @Override
    public void t() {
        super.t();
        System.out.println("Sub t");
    }
    
}

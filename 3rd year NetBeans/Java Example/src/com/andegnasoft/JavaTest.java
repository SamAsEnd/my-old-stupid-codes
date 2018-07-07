package com.andegnasoft;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Oops oops = new Oops(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    private static class Oops {

        int i;
        
        static Logger global = Logger.getGlobal();
        static {
            try {
                global.addHandler(new FileHandler("sam.log", true));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        public Oops(int i) {
            this.i = i;
            System.out.println("Oops: " + i);
            global.info("Oops: " + i);
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            global.info("finalize: " + i);
        }

    }

}

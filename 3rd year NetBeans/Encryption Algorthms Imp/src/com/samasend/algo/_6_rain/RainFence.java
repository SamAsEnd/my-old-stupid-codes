package com.samasend.algo._6_rain;

import com.samasend.algo.GenericEncryption;

public class RainFence extends GenericEncryption {

    public static void main(String[] args) {
        RainFence rainFence = new RainFence();
        rainFence.setKey("2");
        rainFence.setPlainText("meet me after the toga party");
        rainFence.encrypt();
        System.out.println("Cipher: " + rainFence.getCipher() + "\n");
    }

    private int keyI;

    @Override
    public void encrypt() {
        cipher = "";

        String[] rain = new String[keyI];
        for (int i = 0; i < rain.length; i++) {
            rain[i] = "";
        }
        int c = 0;
        boolean up = false;
        for (int i = 0; i < plainText.length(); i++) {
            char pChar = plainText.charAt(i);
            rain[c] += pChar;
            if (up) {
                if (c - 1 < 0) {
                    up = false;
                    c++;
                } else {
                    c--;
                }
            } else {
                if (c + 1 >= keyI) {
                    up = true;
                    c--;
                } else {
                    c++;
                }
            }
        }
        for (String r : rain) {
            cipher += r;
        }
    }

    @Override
    public void setPlainText(String plainText) {
        this.plainText = removeSpace(plainText.toUpperCase());
    }

    @Override
    public void setCipher(String cipher) {
        this.cipher = removeSpace(cipher.toUpperCase());
    }

    public void setKey(int key) {
        this.keyI = key;
    }

    @Override
    public void setKey(String key) {
        setKey(Integer.parseInt(key));
    }

    @Override
    public void decrypt() {

    }

}

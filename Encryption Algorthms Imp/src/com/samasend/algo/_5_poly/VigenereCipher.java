package com.samasend.algo._5_poly;

import com.samasend.algo.GenericEncryption;

public class VigenereCipher extends GenericEncryption {

    public static void main(String[] args) {
        VigenereCipher cipher = new VigenereCipher();
        cipher.setKey("3");
        cipher.setKey("deceptive");
        //encrypt
        cipher.setPlainText("we are discovered save yourself");
        cipher.encrypt();
        System.out.println("Cipher: " + cipher.getCipher() + "\n");
        //decrypt
        cipher.setCipher("ZICVTWQNGRZGVTWAVZHCQYGLMGJ");
        cipher.decrypt();
        System.out.println("Plain Text: " + cipher.getPlainText() + "\n");
    }

    @Override
    public void encrypt() {
        cipher = "";
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = (char) (plainText.charAt(i) - 65);
            int keyI = key.charAt(i % key.length()) - 65;
            plainChar += keyI;
            plainChar %= 26;
            plainChar += 65;
            cipher += plainChar;
        }
    }

    @Override
    public void decrypt() {
        plainText = "";
        for (int i = 0; i < cipher.length(); i++) {
            char plainChar = (char) (cipher.charAt(i) - 65);
            int keyI = key.charAt(i % key.length()) - 65;
            plainChar -= keyI;
            plainChar += 26;
            plainChar %= 26;
            plainChar += 65;
            plainText += plainChar;
        }
    }

    @Override
    public void setKey(String key) {
        this.key = removeSpace(key.toUpperCase());
    }

    @Override
    public void setPlainText(String plainText) {
        this.plainText = removeSpace(plainText.toUpperCase());
    }

    @Override
    public void setCipher(String cipher) {
        this.cipher = removeSpace(cipher.toUpperCase());
    }

}

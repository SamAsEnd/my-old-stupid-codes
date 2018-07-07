package com.samasend.algo._2_monoalpha;

import com.samasend.algo.Alphabet;
import com.samasend.algo.GenericEncryption;
import com.samasend.algo.InvalidKeyException;

public class MonoalphabeticCipher extends GenericEncryption implements Alphabet {

    public static void main(String[] args) {
        MonoalphabeticCipher cipher = new MonoalphabeticCipher();
        cipher.setKey("jrsqxzoewndyvpfatbcilhgkmu");
        //encrypt
        cipher.setPlainText("meet me after the toga party");
        cipher.encrypt();
        System.out.println("Cipher: " + cipher.getCipher() + "\n");
        //decrypt
        cipher.setCipher("VXXIVXJZIXBIEXIFOJAJBIM");
        cipher.decrypt();
        System.out.println("Plain Text: " + cipher.getPlainText() + "\n");
    }

    @Override
    public void setPlainText(String plainText) {
        super.setPlainText(removeSpace(plainText.toUpperCase()));
    }

    @Override
    public void setCipher(String cipher) {
        super.setCipher(removeSpace(cipher.toUpperCase()));
    }

    @Override
    public void encrypt() {
        cipher = "";
        for (int i = 0; i < plainText.length(); i++) {
            char p = plainText.charAt(i);
            int index = ALPHABET.indexOf(p);
            char c = key.charAt(index);
            cipher += c;
        }
    }

    @Override
    public void decrypt() {
        plainText = "";
        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);
            int index = key.indexOf(c);
            char p = ALPHABET.charAt(index);
            plainText += p;
        }
    }

    @Override
    public void setKey(String k) {
        String tmpKeyUpperCase = k.toUpperCase();
        if (!checkForValidity(tmpKeyUpperCase)) {
            throw new InvalidKeyException("Key must be length 26 with all characters");
        }
        this.key = tmpKeyUpperCase;
    }

    private boolean checkForValidity(String key) {
        // check length
        if (key.length() != 26) {
            return false;
        }
        // check if all chars exist from alphabet
        for (int i = 0; i < 26; i++) {
            if (-1 == key.indexOf(Alphabet.ALPHABET.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

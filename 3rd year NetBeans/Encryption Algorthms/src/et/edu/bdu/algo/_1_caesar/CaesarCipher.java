package et.edu.bdu.algo._1_caesar;

import et.edu.bdu.algo.GenericEncryption;
import et.edu.bdu.algo.InvalidKeyException;

public class CaesarCipher extends GenericEncryption {

    // for testing
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        cipher.setKey("3");
        //encrypt
        cipher.setPlainText("meet me after the toga party");
        cipher.encrypt();
        System.out.println("Cipher: " + cipher.getCipher() + "\n");
        //decrypt
        cipher.setCipher("PHHW PH DIWHU WKH WRJD SDUWB");
        cipher.decrypt();
        System.out.println("Plain Text: " + cipher.getPlainText() + "\n");
    }

    private int keyI;

    @Override
    public void encrypt() {
        // tmp stores the msg in ALL CAPITAL
        String tmp = plainText.toUpperCase();
        // words is where the encrypt letters are stored
        char[] words = new char[tmp.length()];

        // loop through the String
        for (int i = 0; i < tmp.length(); i++) {
            // get the equvalent int from the index char
            int t = tmp.charAt(i);

            // if the char is a SPACE skip
            if (t == ' ') {
                words[i] = ' ';
                continue;
            }

            // if the word SHOULD round up
            if (t + keyI > 90) {
                // eg if t = 89(Y) and key is 2
                // the sum is 91 w/c is > than Z
                // so i round it by subtracting 26 ---> 65(A)
                // Y --> 2 = A
                t -= 26;
            }
            // add the key
            t += keyI;

            // build the encrypted word to String
            words[i] = (char) t;
        }

        cipher = new String(words);
    }

    @Override
    public void decrypt() {
        // tmp stores the msg in ALL CAPITAL
        String tmp = cipher.toUpperCase();
        // words is where the encrypt letters are stored
        char[] words = new char[tmp.length()];

        // loop through the String
        for (int i = 0; i < tmp.length(); i++) {
            // get the equvalent int from the index char
            int t = tmp.charAt(i);

            // if the char is a SPACE skip
            if (t == ' ') {
                words[i] = ' ';
                continue;
            }

            // if the word SHOULD round up
            if (t - keyI < 65) {
                // eg if t = 66(B) and key is 2
                // the sub is 64 w/c is < than A
                // so i round it by adding 26 ---> 90(Z)
                // B <-- 2 = Z
                t += 26;
            }
            // add the key
            t -= keyI;

            // build the encrypted word to String
            words[i] = (char) t;
        }

        plainText = new String(words);
    }

    @Override
    public String getKey() {
        return "" + keyI;
    }

    @Override
    public void setKey(String key) {
        setKey(Integer.parseInt(key));
    }

    private void setKey(int key) {
        if (key > 25 || key < 0) {
            throw new InvalidKeyException("Key must be between 0 and 25");
        }
        keyI = key;
    }

}

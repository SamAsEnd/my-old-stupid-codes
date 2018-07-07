package et.edu.bdu.algo._7_block;

import et.edu.bdu.algo.GenericEncryption;

public class Block_ColumnarCipher extends GenericEncryption {

    public static void main(String[] args) {
        Block_ColumnarCipher cipher = new Block_ColumnarCipher();
        cipher.setKey("4312567");

        //encrypt
        cipher.setPlainText("attack postponed until two am");
        cipher.encrypt();
        System.out.println("Cipher: " + cipher.getCipher() + "\n");
        //decrypt
        cipher.setCipher("TTNAAPTMTSUOAODWCOIXKNLYPETZ");
        cipher.decrypt();
        System.out.println("Plain Text: " + cipher.getPlainText() + "\n");
    }

    private int[] keyArray;

    @Override
    public void encrypt() {
        cipher = "";
        int diff = plainText.length() % keyArray.length;
        if (diff != 0) {
            String tmp = "ZYXWVUTSRQPON . . . ".substring(0, keyArray.length - diff);
            plainText += new StringBuffer(tmp).reverse().toString();
            // check for more addin
            //System.out.println(plainText);
        }
        String[] block = new String[keyArray.length];
        for (int i = 0; i < block.length; i++) {
            block[i] = "";
        }
        for (int i = 0; i < plainText.length(); i++) {
            char pCh = plainText.charAt(i);
            int index = i % keyArray.length;
            block[keyArray[index] - 1] += pCh;
        }
        for (String block1 : block) {
            cipher += block1;
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

    @Override
    public void setKey(String key) {
        keyArray = new int[key.length()];
        for (int i = 0; i < keyArray.length; i++) {
            keyArray[i] = Integer.parseInt("" + key.charAt(i));
        }
        this.key = key;
    }

    @Override
    public void decrypt() {
        plainText = "";
        int len = cipher.length() / keyArray.length;

        String[] block = new String[keyArray.length];
        for (int i = 0; i < block.length; i++) {
            block[i] = "";
        }
        for (int i = 0; i < keyArray.length; i++) {
            block[i] += cipher.substring(i * len, i * len + len);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < keyArray.length; j++) {
                plainText += block[keyArray[j] - 1].charAt(i);
            }
        }
    }

}

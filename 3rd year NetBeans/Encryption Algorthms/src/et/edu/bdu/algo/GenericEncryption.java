package et.edu.bdu.algo;

public abstract class GenericEncryption {

    public static String removeSpace(String txt) {
        String noSpaceString = "";
        for (int i = 0; i < txt.length(); i++) {
            if (Character.isLetter(txt.charAt(i))) {
                noSpaceString += txt.charAt(i);
            }
        }
        return noSpaceString;
    }

    protected String plainText;
    protected String cipher;
    protected String key;

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public abstract void encrypt();

    public abstract void decrypt();

}

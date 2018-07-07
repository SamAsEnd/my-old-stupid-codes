package et.edu.bdu.algo._4_hill;

import et.edu.bdu.algo.Alphabet;
import et.edu.bdu.algo.GenericEncryption;
import et.edu.bdu.algo.InvalidKeyException;

public class HillCipher extends GenericEncryption implements Alphabet {

    public static void main(String[] args) {
        HillCipher cipher = new HillCipher();

        int[][] mat
                = {{17, 17, 5},
                {21, 18, 21},
                {2, 2, 19}};
        cipher.setKeyMatrix(mat);

        cipher.setPlainText("paymoremoney");
        cipher.encrypt();
        System.out.println("Cipher: " + cipher.getCipher() + "\n");
        System.exit(0);
    }

    private int keyMatrix[][] = null;
    private int m;

    public int[][] getKeyMatrix() {
        return keyMatrix;
    }

    public void setKeyMatrix(int[][] keyMatrix) {
        m = keyMatrix.length;
        // BUILD the String key
        String tmp = "";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tmp += ALPHABET.charAt(keyMatrix[i][j]);
            }
        }
        this.keyMatrix = keyMatrix;
    }

    @Override
    public void setKey(String key) {
        double sqD = Math.sqrt(key.length());
        int sqI = (int) sqD;
        if (sqD - sqI != 0.0) { // not perfect square
            throw new InvalidKeyException("Key must be a squere of a number");
        }
        buildMatrix(key.toUpperCase());
        super.setKey(key);
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
        for (int i = 0; i < plainText.length(); i += m) {
            int[] ch = new int[m];
            char[] c = new char[m];
            for (int j = 0; j < ch.length; j++) {
                char tCh = 'X';
                try {
                    tCh = plainText.charAt(i + j);
                } catch (Exception e) {
                }
                ch[j] = (tCh - 65);
            }
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += (keyMatrix[j][k] * ch[k]);
                }
                sum %= 26;
                c[j] = (char) (sum + 65);
            }
            cipher += (new String(c));
        }
    }

    @Override
    public void decrypt() {

        int[][] keyInverse = getInverse();

        plainText = "";
        for (int i = 0; i < cipher.length(); i += m) {
            int[] ch = new int[m];
            char[] c = new char[m];
            for (int j = 0; j < ch.length; j++) {
                char tCh = 'X';
                try {
                    tCh = cipher.charAt(i + j);
                } catch (Exception e) {
                }
                ch[j] = (tCh - 65);
            }
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += (keyInverse[j][k] * ch[k]);
                }
                sum %= 26;
                c[j] = (char) (sum + 65);
            }
            plainText += (new String(c));
        }
    }

    private void buildMatrix(String key) {
        m = (int) Math.sqrt(key.length());
        keyMatrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                char ch = key.charAt(i * m + j);
                int index = ALPHABET.indexOf("" + ch);
                keyMatrix[i][j] = index;
            }
        }
    }

    private int[][] getInverse() {
        // FIXME: replace with matrix inverting lib
        return keyMatrix;
    }

    public void printMatrix() {
        System.out.println("\nMATRIX");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(keyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String getMatrix() {
        String matrix = "MATRIX";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix += (keyMatrix[i][j] + " ");
            }
            matrix += "\n";
        }
        return matrix;
    }
}

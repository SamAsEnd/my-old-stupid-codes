package et.edu.bdu.algo._3_playfair;

import et.edu.bdu.algo.Alphabet;
import et.edu.bdu.algo.GenericEncryption;
import java.util.ArrayList;
import java.util.Stack;

public class PlayFairCipher extends GenericEncryption implements Alphabet {

    // test
    public static void main(String[] args) {
        PlayFairCipher cipher = new PlayFairCipher();
        cipher.setKey("playfair example");
        cipher.printMatrix();
        //encrypt
        cipher.setPlainText("Hide the gold in the tree stump");
        cipher.encrypt();
        System.out.println("Cipher: " + cipher.getCipher() + "\n");
        //decrypt
        cipher.setCipher("BM OD ZB XD NA BE KU DM UI XM MO UV IF");
        cipher.decrypt();
        System.out.println("Plain Text: " + cipher.getPlainText() + "\n");
    }

    private static ArrayList<String> getPairs(String text) {
        String rawTxt = removeSpace(text.toUpperCase());

        ArrayList<String> pairs = new ArrayList<String>();
        for (int i = 0; i < rawTxt.length(); i++) {
            char firstChar = rawTxt.charAt(i);
            char secondChar = 0;
            try {
                secondChar = rawTxt.charAt(i + 1);
            } catch (Exception ignore) {
                // reached the end
            }
            String tmp = "" + firstChar;
            if (firstChar == secondChar || secondChar == 0) {
                secondChar = 'X'; // double word or reached the end
            } else {
                i++; // normal flow skip the next word
            }
            tmp += secondChar; // add the second word
            pairs.add(tmp);
        }
        return pairs;
    }

    private final char[][] keyMatrix = new char[5][5];

    public void printMatrix() {
        System.out.println("\n MATRIX");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(keyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void encrypt() {
        ArrayList<String> pairs = getPairs(plainText);
        cipher = "";
        for (String words : pairs) {
            int f[] = indexInMatrix(words.charAt(0));
            int s[] = indexInMatrix(words.charAt(1));
            // RULE 1 SAME ROW
            if (f[0] == s[0]) {
                f[1]++;
                s[1]++;
                // last element go round
                if (f[1] >= 5) {
                    f[1] = 0;
                }
                if (s[1] >= 5) {
                    s[1] = 0;
                }
            } // RULE 2 SAME COLUMN
            else if (f[1] == s[1]) {
                f[0]++;
                s[0]++;
                // last element go round
                if (f[0] >= 5) {
                    f[0] = 0;
                }
                if (s[0] >= 5) {
                    s[0] = 0;
                }
            } // RULE 3 rectangle
            else {
                int t = f[1];
                f[1] = s[1];
                s[1] = t;
            }
            char cf = keyMatrix[f[0]][f[1]];
            char cs = keyMatrix[s[0]][s[1]];
            cipher += (cf + "" + cs);
        }
    }

    @Override
    public void decrypt() {
        ArrayList<String> pairs = getPairs(cipher);
        plainText = "";
        for (String words : pairs) {
            int f[] = indexInMatrix(words.charAt(0));
            int s[] = indexInMatrix(words.charAt(1));
            // RULE 1 SAME ROW
            if (f[0] == s[0]) {
                f[1]--;
                s[1]--;
                // last element go round
                if (f[1] < 0) {
                    f[1] = 4;
                }
                if (s[1] < 0) {
                    s[1] = 4;
                }
            } // RULE 2 SAME COLUMN
            else if (f[1] == s[1]) {
                f[0]--;
                s[0]--;
                // last element go round
                if (f[0] < 0) {
                    f[0] = 4;
                }
                if (s[1] < 0) {
                    s[0] = 4;
                }
            } // RULE 3 rectangle
            else {
                int t = f[1];
                f[1] = s[1];
                s[1] = t;
            }
            char cf = keyMatrix[f[0]][f[1]];
            char cs = keyMatrix[s[0]][s[1]];
            plainText += (cf + "" + cs);
        }
    }

    @Override
    public void setKey(String key) {
        String tmpkeyUpper = key.toUpperCase().replace('J', 'I');

        buildMatrix(tmpkeyUpper);
        this.key = tmpkeyUpper;
    }

    private void buildMatrix(String tmpkeyUpper) {
        String tmpTrickBuffer = "";
        int keyIndex = 0;
        int alphabetIndex = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                do {
                    if (keyIndex < tmpkeyUpper.length()) {
                        if (tmpkeyUpper.charAt(keyIndex) == ' ' || tmpTrickBuffer.contains("" + tmpkeyUpper.charAt(keyIndex))) {
                            keyIndex++;
                            continue;
                        }
                        keyMatrix[i][j] = tmpkeyUpper.charAt(keyIndex);
                        tmpTrickBuffer += tmpkeyUpper.charAt(keyIndex);
                        keyIndex++;
                        break;
                    } else {
                        if (tmpTrickBuffer.contains("" + PLAY_FAIR_ALPHABET.charAt(alphabetIndex))) {
                            alphabetIndex++;
                            continue;
                        }
                        keyMatrix[i][j] = PLAY_FAIR_ALPHABET.charAt(alphabetIndex);
                        tmpTrickBuffer += PLAY_FAIR_ALPHABET.charAt(alphabetIndex);
                        alphabetIndex++;
                        break;
                    }
                } while (true);
            }
        }
    }

    private int[] indexInMatrix(char ch) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == ch) {
                    int[] r = {i, j};
                    return r;
                }
            }
        }
        return null;
    }

    public Stack<Stack<Character>> getMatrix() {
        Stack<Stack<Character>> characters = new Stack<Stack<Character>>();
        for (char[] cs : keyMatrix) {
            Stack<Character> stack = new Stack<Character>();
            for (char c : cs) {
                stack.add(c);
            }
            characters.add(stack);
        }
        return characters;
    }

    @Override
    public void setPlainText(String plainText) {
        super.setPlainText(plainText.toUpperCase().replace('J', 'I'));
    }

    @Override
    public void setCipher(String cipher) {
        super.setCipher(cipher.toUpperCase().replace('J', 'I'));
    }

}

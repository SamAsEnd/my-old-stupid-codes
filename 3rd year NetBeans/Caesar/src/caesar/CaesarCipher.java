package caesar;

import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter TXT: ");
        String plainTxt = scanner.nextLine();
        System.out.print("Enter KEY: ");
        int key = scanner.nextInt();

        String ciper = encrypt(plainTxt, key);
        System.out.println(ciper);
        plainTxt = decrypt(ciper, key);
        System.out.println(plainTxt);
    }

    private static String encrypt(String plainTxt, int key) {
        String tmp = plainTxt.toUpperCase();
        String Y = "";

        for (int i = 0; i < tmp.length(); i++) {
            char t = tmp.charAt(i);
            if (t == ' ') {
                t = ' ';
            } else {
                t += key;
                if (t > 90) {
                    t -= 26;
                }
            }
            Y += t;
        }
        return Y;
    }

    private static String decrypt(String plainTxt, int key) {
        String tmp = plainTxt.toUpperCase();
        String Y = "";

        for (int i = 0; i < tmp.length(); i++) {
            char t = tmp.charAt(i);
            if (t == ' ') {
                t = ' ';
            } else {
                t -= key;
                if (t < 65) {
                    t += 26;
                }
            }
            Y += t;
        }
        return Y;
    }

}

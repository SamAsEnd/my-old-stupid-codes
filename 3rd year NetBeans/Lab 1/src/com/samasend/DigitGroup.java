package com.samasend;

import java.util.Stack;

/**

 @author SamAsEnd
 */
public class DigitGroup {

    private String word;
    private long num;

    public DigitGroup(long num) {
        this.num = num;
        group();
    }

    private void group() {
        Stack<String> w = new Stack<>();
        char[] words = new StringBuffer("" + num)
                .reverse()
                .toString().
                toCharArray();
        for (char c : words) {
            w.push("" + c);
        }
        word = "";
        while (!w.empty()) {
            int size = w.size();
            if (size % 3 == 0 && size > 0) {
                word += " ";
            }
            String t = w.pop();
            word += t;
        }
        // to remove the heading comma tricky
        word = word.trim();
        word = word.replace(' ', ',');
    }

    @Override
    public String toString() {
        return word;
    }

}

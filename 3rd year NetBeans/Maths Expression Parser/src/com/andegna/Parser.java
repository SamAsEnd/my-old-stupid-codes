package com.andegna;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Parser {

    public static void main(String[] args) throws IOException {
        Scanner real_keyboard = new Scanner(System.in);
        Stack<String> ops = new Stack<>();
//        Stack<String> tokens = new Stack<>();

        System.out.println("Enter the post-fix expression: ");
        Scanner keyboard = new Scanner(real_keyboard.nextLine());
//        Pattern pattern = Pattern.compile();
        
        String token = keyboard.nextLine();
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(token));
        
        tokenizer.eolIsSignificant(false);
        tokenizer.lowerCaseMode(false);
        tokenizer.parseNumbers();
        
//        char c = '';
//        while (c == '') {            
            
        }
        
//        tokenizer.wordChars('', '\127');
        int t;
        
//        while(tokenizer.TT_EOF != (t = tokenizer.nextToken())) {
//            if(t == tokenizer.TT_WORD) {
//                System.out.println(tokenizer.sval);
//            }  
//            else if(t == tokenizer.TT_NUMBER) {
//                System.out.println(tokenizer.nval);
//            } else {
//                System.out.println((char)t);
//            }
//        }
        
        // 
//        for (String t : tokens) {
//            System.out.println(t);
//        }
//    }

}

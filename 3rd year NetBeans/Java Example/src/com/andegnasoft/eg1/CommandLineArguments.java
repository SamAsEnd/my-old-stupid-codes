package com.andegnasoft.eg1;

public class CommandLineArguments {

    public static void main(String[] args) {
        System.out.println(args.length + " arguments passed!");
        for (String arg : args) {
            System.out.println("> "+arg);
        }
    }
    
}

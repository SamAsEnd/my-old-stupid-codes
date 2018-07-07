package com.samasend.mysql;

public class Sequence {

    Sequence() {
        System.out.print("c ");
    }

    {
        System.out.print("y ");
    }

    public static void main(String[] args) {
        new Sequence().go();
    }

    void go() {
        System.out.print("g ");
    }

    static {
        System.out.print("x ");
    }
}
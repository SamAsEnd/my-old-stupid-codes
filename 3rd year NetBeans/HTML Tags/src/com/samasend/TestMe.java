package com.samasend;

public class TestMe {
    static {
        System.out.println("static init");
    }

    public static void main(String[] args) {
        System.out.println("main");
        TestMe testMe = new TestMe();
    }

    {
        System.out.println("init");
    }

    public TestMe() {
        System.out.println("constructor");
    }

}

package samasend.multi.threading;

import java.util.ArrayList;
import java.util.Arrays;

public class SamAsEndMultiThreading {

    public static void main(String[] args) {
        
        TestThread[] t = new TestThread[3];
        ArrayList<TestThread> a = new ArrayList<>();
        a.addAll(Arrays.asList(t));
        
        for (TestThread testThread : a) {
            testThread = new TestThread();
            System.out.println(String.format("Thread %d has created", testThread.getId()));
            testThread.start();
            System.out.println(String.format("Thread %d has started", testThread.getId()));
        }
    }
}

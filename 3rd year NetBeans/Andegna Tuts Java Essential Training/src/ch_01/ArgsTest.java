package ch_01;

public class ArgsTest {

    public static void main(String[] args) {
        System.out.println("Number of arguments: "+args.length);
        
        for (String arg : args) {
            System.out.println(arg);
        }
    }
    
}

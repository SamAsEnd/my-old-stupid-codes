/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mic;

/**
 *
 * @author SamAsEnd
 */
import java.util.Scanner;
public class Mic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner we=new Scanner(System.in);
        int w,r,sum;
         System.out.println("enter the num");
         w=we.nextInt();
        System.out.println("enter the  second num");
         r=we.nextInt();
         sum=r+w;
        System.out.println("sum is %d\n",sum);
    }
}

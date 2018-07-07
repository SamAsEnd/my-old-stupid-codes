package edu.mum.samsone.endale;

public class Question {

    public static int q1(int[] a) {
        int max1, max2;
        max1 = max2 = -1;
        
        for (int i : a) {
            if(i > max1) {
                max2 = max1;
                max1 = i;
            }
            else if (i < max1 && i > max2) {
                max2 = i;
            }
        }
        
        return max2;
    }
    
    public static int q2(int[] a) {
        int odd,even;
        odd = even = 0; // for readable
        
        for (int i : a) {
            if(i % 2 == 0) { 
                even += i;
            } else {
                odd += i;
            }
        }
        
        return odd - even;
    }
    
    public static char[] q3(char[] a, int start, int len) {
        String string = new String(a);
        try {
            return string.substring(start, len).toCharArray();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}

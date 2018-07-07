
import java.util.Arrays;

public class Q3 {

    public static char[] f(char[] a, int start, int len) {
        if (start >= 0 && start + len <= a.length) {
            char[] result = new char[len];
            for (int i = 0; i < len; i++) {
                result[i] = a[i + start];
            }
            return result;
        }
        return null;
    }

    public static String print(char[] a) {
        return Arrays.toString(a);
    }

    public static void main(String[] args) {
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 0, 4)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 0, 3)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 0, 2)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 0, 1)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 1, 3)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 1, 2)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 1, 1)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 2, 2)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 2, 1)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 3, 1)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, 1, 0)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, -1, 2)));
        System.out.println(print(f(new char[]{'a', 'b', 'c'}, -1, -2)));
        System.out.println(print(f(new char[]{}, 0, 1)));

    }

}

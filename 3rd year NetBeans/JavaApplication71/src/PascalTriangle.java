
public class PascalTriangle {

    public static void main(String[] args) {

        int[][] array = new int[6][6];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                try {
                    array[i][j] = array[i-1][j] + array[i-1][j-1];
                } catch (Exception e) {
                    array[i][j] = 1;
                }
            }
        }

        for (int[] is : array) {
            for (int i : is) {
                if(i == 0) {
                    continue;
                }
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

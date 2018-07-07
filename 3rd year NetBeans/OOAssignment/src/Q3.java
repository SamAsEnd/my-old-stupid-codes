import java.io.*;
class Q3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        System.out.println(str);
        
        /*
         * easy tip 
         * 
         * System.out.println(new BufferedReader(new InputStreamReader(System.in)).readLine());
         * 
         */   
    }
}

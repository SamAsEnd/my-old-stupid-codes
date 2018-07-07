package sort.word.list;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class LoadAndDisplaySourse {

    public static void main(String[] args) throws Exception {
        String urlString = "ftp://ftp.awl.com/cseng/authors/elmasri/Dbase5e/labmanual/ch6/";
        
        URL url = new URL(urlString);
        
        int read = 0;
        InputStream openStream = url.openStream();
        while ((read = openStream.read()) != -1) {
            System.out.print((char)read);
        }
        
    }

}

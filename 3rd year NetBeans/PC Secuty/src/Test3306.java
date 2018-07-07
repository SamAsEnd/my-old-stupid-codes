
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;


public class Test3306 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("169.254.112.122", 3306);
    }

}

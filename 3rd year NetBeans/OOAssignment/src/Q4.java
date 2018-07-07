
import com.sun.org.apache.xpath.internal.operations.Variable;
import java.io.DataInputStream;
import java.io.IOException;

class Q4 {

    public static void main(String[] args) {
        DataInputStream dataInputStream = new DataInputStream(System.in);
        try {
            System.out.print("   byte: ");
            byte vB = dataInputStream.readByte();
            System.out.print("  short: ");
            short vS = dataInputStream.readShort();
            System.out.print("    int: ");
            int vI = dataInputStream.readInt();
            System.out.print("   long: ");
            long vL = dataInputStream.readLong();

            System.out.print("  float: ");
            float vF = dataInputStream.readFloat();
            System.out.print(" double: ");
            double vD = dataInputStream.readDouble();

            System.out.print("   char: ");
            char vC = dataInputStream.readChar();
            System.out.print("boolean: ");
            boolean vBool = dataInputStream.readBoolean();
            System.out.println("   byte: "+vB);
            System.out.println("  short: "+vS);
            System.out.println("    int: "+vI);
            System.out.println("   long: "+vL);
            System.out.println("  float: "+vF);
            System.out.println(" double: "+vD);
            System.out.println("   char: "+vC);
            System.out.println("boolean: "+vBool);
        } catch (Exception iOException) {
            System.out.println("IOException: \n" + iOException.getMessage());
        }

    }
}

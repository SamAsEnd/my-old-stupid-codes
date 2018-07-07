package com.samasend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SamAsEnd
 */
public class RecievedSock implements Runnable {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public RecievedSock(Socket socket) throws IOException {
        this.socket = socket;
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            String dataIn = in.readUTF();
            String dataOut = "HTTP/1.1 200 OK\n"
                    //+ "Date: "+ DateFormat.getInstance().format(new Date())+"\n"//"Wed, 13 Sep 2000 20:29:50 GMT\n"
                    //+ "Server: Sam As End (Windows)\n"
                    //+ "Last-Modified: Tue, 05 Sep 2000 06:52:39 GMT\n"
                    //+ "ETag: \"a9260-18a-39b49837\"\n"
                    //+ "Accept-Ranges: bytes\n"
                    //+ "Content-Length: 394\n"
                    //+ "Content-Type: text/html\n"
                    + "\n"
                    + "<HTML>\n"
                    + "<!--- Dave Reed index.html 8/17/00 -->\n"
                    + "<!--------------------------------------------------->\n"
                    + "<HEAD>\n"
                    + "<TITLE>Dave Reed's Home Page</TITLE>\n"
                    + "<SCRIPT LANGUAGE=\"JavaScript\">\n"
                    + "if (self!=top) \n"
                    + "top.location.href=self.location.href;\n"
                    + "</SCRIPT>\n"
                    + "</HEAD>\n"
                    + "<FRAMESET COLS=\"170,*\">\n"
                    + "<FRAME SRC=\"menu.html\" NAME=\"menu\">\n"
                    + "<FRAME SRC=\"info.html\" NAME=\"main\">\n"
                    + "</FRAMESET>\n"
                    + "</HTML>";
            out.writeUTF(dataOut);
            System.out.println("done");
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

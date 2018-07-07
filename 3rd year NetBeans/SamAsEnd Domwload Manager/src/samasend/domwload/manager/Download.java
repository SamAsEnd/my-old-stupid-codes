package samasend.domwload.manager;

import com.sun.swing.internal.plaf.basic.resources.basic_ja;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import sun.awt.windows.ThemeReader;

public class Download extends Thread {

    private static void detail() {
        for (Iterator<Download> it = we.iterator(); it.hasNext();) {
            Download download = it.next();
            download.getDetail();
        }
    }

    private void getDetail() {
        toString();
    }
    private File tempFile;
    private InputStreamReader in;
    private FileWriter out;
    private int start;
    private int current;
    private int last;
    private long speedInNano;
    private boolean done;
    private URL url;
    private char buffer[];
    private static ArrayList<Download> we;

    public Download(URL url, int start, int last) throws IOException {
        super();
        if (we == null) {
            we = new ArrayList<>();
        }
        we.add(this);
        this.url = url;
        tempFile = File.createTempFile(url.getFile(), ".sam.tmp");
        in = new InputStreamReader(url.openStream());
        out = new FileWriter(tempFile);
        this.start = start;
        this.last = last;
        current = start;
        speedInNano = 0;
        done = false;
        buffer = new char[1024 * 1024];
        this.start();
    }

    private Download(URL url) throws IOException {
        this(url, 0, url.openConnection().getContentLength());
    }

    @Override
    public void run() {
        super.run();
        int downloaded = 0;
        try {
            while ((downloaded = (in.read(buffer, current, last))) != -1) {
                out.write(buffer);
                current += (downloaded * 2);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    ex.toString();
                }
                split(this);
            }
        }
        catch (IOException iOException) {
            speedInNano = 0;
            iOException.toString();
        }
        catch (Exception ex) {
            speedInNano = 0;
            ex.toString();
        }
        
    }

    public File getTempFile() {
        return tempFile;
    }

    public long getSpeedInNano() {
        return speedInNano;
    }

    public boolean isDone() {
        return done;
    }

    public int getStart() {
        return start;
    }

    public int getLast() {
        return last;
    }

    public URL getUrl() {
        return url;
    }

    public int getCurrent() {
        return current;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public static void split(Download d) throws IOException {
        if (getNummberOfDownload() <= 8) {
            int c = d.getCurrent();
            int l = d.getLast();

            int len = (l - c) / 2;
            Download newDownload = new Download(new URL(d.getUrl(), ""), c + len + 1, len);
            d.setLast(c + len);
            detail();
        }
    }

    public static int getNummberOfDownload() {
        return we.size();
    }

    public static void main(String... args) {
        try {
            new Download(new URL("http://localhost/equilibrium.mkv"));
        } catch (MalformedURLException ex) {
            ex.toString();
        } catch (IOException ex) {
            ex.toString();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Download.detail();
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.toString();
                    }
                }
            }
        });

    }
}

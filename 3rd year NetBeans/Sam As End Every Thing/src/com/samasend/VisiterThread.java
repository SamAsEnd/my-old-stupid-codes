package com.samasend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisiterThread extends Thread{
    
    Path path;
    SamAsEndFileVisiter visiter;

    public VisiterThread(Path path, SamAsEndFileVisiter visiter) {
        this.path = path;
        this.visiter = visiter;
        setPriority(MAX_PRIORITY);
    }

    @Override
    public void run() {
        super.run();
        try {
            Files.walkFileTree(path, visiter);
            SamAsEndFileVisiter.nuberOfFileVisiter--;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

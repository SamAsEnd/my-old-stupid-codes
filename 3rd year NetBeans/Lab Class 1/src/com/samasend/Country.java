package com.samasend;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;

public class Country {

    private String name_en;
    private String name_am;
    private Image flag;
    private InputStream anthem;

    public Country(String url) {
        try {
            name_en = url.substring(0, url.indexOf("."));
            flag = ImageIO.read(getClass().getResourceAsStream("/flags" + url));
            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(Country.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getName() {
        return name_en;
    }

    public Image getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return getName();
    }

}

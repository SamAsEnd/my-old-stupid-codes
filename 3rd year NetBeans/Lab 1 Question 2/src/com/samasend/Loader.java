package com.samasend;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Sam As End
 */
public class Loader {

    public ArrayList<Country> getCountries() {

        ArrayList<Country> countries = new ArrayList<>();

        String[] c = {
            "Ethiopia",
            "Kenya",
            "Sudan",
            "Djibouti",
            "Eritrea",
            "Egypt"
        };

        for (String countryName : c) {
            try {
                Country country = new Country(countryName);

                CountryAccept countryAccept = new CountryAccept(new JFrame(), true, country);
                countryAccept.setLocationRelativeTo(null);
                countryAccept.setVisible(true);

//                country.setAnnualProduct(random());
//                country.setGdp(random());
//                country.setGrowthLevel(random());
//                country.setPoliticalGrowth(random());
//                country.setRainFall(random());
                
                country.calculateState();
                countries.add(country);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return countries;
    }

    int random() {
        int r = (int) (Math.random() * 100);
        return r;
    }

}

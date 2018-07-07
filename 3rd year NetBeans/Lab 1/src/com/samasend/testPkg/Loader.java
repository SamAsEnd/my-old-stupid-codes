package com.samasend.testPkg;

import com.samasend.Country;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.TreeSet;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**

 @author Sam As End
 */
public class Loader {

    private Vector<Country> countries;

    public static void main(String[] args) throws Exception {
        new Loader();
    }

    public Loader() throws Exception {

        TreeSet<String> strings = new TreeSet<>();

        InputStream inputStream = getClass().getResourceAsStream("/com/samasend/data/CountryAmName.xml");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(inputStream);

        //doc.getDocumentElement().normalize();
        NodeList nodes = doc.getElementsByTagName("Country");

        countries = new Vector<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            countries.add(new Country(element.getAttribute("code"), element.getTextContent()));
        }

        inputStream = Loader.class.getResourceAsStream("/com/samasend/data/CountryData.xml");
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = builder.parse(inputStream);

        doc.getDocumentElement().normalize();

        nodes = doc.getElementsByTagName("country");
        /*
         * <country countryCode="ET" countryName="Ethiopia" currencyCode="ETB"
         * population="88013491" fipsCode="ET" isoNumeric="231" north="14.89375"
         * south="3.402422" east="47.986179" west="32.999939" capital="Addis
         * Ababa" continentName="Africa" continent="AF" areaInSqKm="1127127.0"
         * languages="am,en-ET,om-ET,ti-ET,so-ET,sid" isoAlpha3="ETH"
         * geonameId="337996" />
         */
        ImageIcon temp = new ImageIcon(getClass().getResource("/com/samasend/flags/imageNotFound.png"));
        ImageIcon imageNotFound = new ImageIcon(temp.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));

        for (int i = 0; i < nodes.getLength(); i++) {
            Country country = null;
            try {
                Node node = nodes.item(i);
                Element element = (Element) node;
                //System.out.println(element.getAttribute("countryCode") + " _  "
                //+ element.getAttribute("countryName") + " _ " 
                //+ element.getAttribute("capital"));
                country = getCountry(element.getAttribute("countryCode"));
                if (country != null) {
                    try {
                        country.setAreaInSqKm(Double.parseDouble(element.getAttribute("areaInSqKm")));
                    } catch (NumberFormatException nfe) {
                        country.setAreaInSqKm(0);
                    }
                    country.setCapital(element.getAttribute("capital"));
                    country.setContinent(element.getAttribute("continentName"));
                    country.setCurrencyCode(element.getAttribute("currencyCode"));
                    country.setName_en(element.getAttribute("countryName"));
                    try {
                        country.setPopulation(Long.parseLong(element.getAttribute("population")));
                    } catch (NumberFormatException nfe) {
                        country.setPopulation(0);
                    }
                    String u = "/com/samasend/flags/" + country.getName_en() + ".png";
                    URL resource = getClass().getResource(u);
                    if (resource != null) {
                        country.setIcon(new ImageIcon(resource));
                    } else {
                        country.setIcon(imageNotFound);
                        System.err.println("Image not found: " + country.getName_en());
                    }
                    u = "/com/samasend/anthem/" + country.getName_en() + ".mp3";
                    InputStream stream = getClass().getResourceAsStream(u);
                    if (stream != null) {
                        country.setAudio(stream);
                    } else {
                        country.setAudio(null);
                        System.err.println("Audio not found: " + country.getName_en());
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null, ex.getMessage(),
                        ex.getClass().getName(),
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public Vector<Country> getCountries() {
        return countries;
    }

    private Country getCountry(String code) {
        for (Country country : countries) {
            if (country.getCode().equals(code)) {
                return country;
            }
        }
        return null;
    }
}

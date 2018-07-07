package com.samasend;

import processing.core.*;
import static processing.core.PApplet.abs;
import static processing.core.PApplet.constrain;
import static processing.core.PApplet.max;
import static processing.core.PApplet.min;
//import processing.core.PApplet.*;
//import processing.core.PConstants.*;

/**
 *
 * @author SamAsEnd
 */
@SuppressWarnings("serial")
public class Sketch extends PApplet {

    PImage sunflower;
    PImage dog;

    @Override
    public void setup() {
        sunflower = loadImage("data/sunflower.jpg");
        dog = loadImage("data/dog.jpg");
        size(200, 200);
    }

    @Override
    public void draw() {
        loadPixels();
        sunflower.loadPixels();
        dog.loadPixels();
        for (int i = 0; i < pixels.length; i++) {

            pixels[i] = SAEblend(sunflower.pixels[i], dog.pixels[i]);

        }
        updatePixels();
    }

    private int SAEblend(int sun, int dog) {
        float rC, gC, bC;

        int c = sun;
        
        c = SAEDarken(sun, dog);
        //c = SAELighten(sun, dog);
        //c = SAEOvarlay(sun, dog);
        //c = SAEHardLight(sun, dog);
        //c = SAESubtract(sun, dog);  

        return c;
    }

    private int SAESubtract(int sun, int dog) { // mathematical - & AB != BA see z condition
        float rC, gC, bC;

        float rSun = red(sun);
        float gSun = green(sun);
        float bSun = blue(sun);

        float rDog = red(dog);
        float gDog = green(dog);
        float bDog = blue(dog);

        if (!true) {
            rC = rSun - rDog;
            gC = gSun - gDog;
            bC = bSun - bDog;
        } else {
            rC = rDog - rSun;
            gC = gDog - gSun;
            bC = bDog - bSun;
        }

        constrain(rC, 0, 255);
        constrain(gC, 0, 255);
        constrain(bC, 0, 255);

        return color(rC, gC, bC);
    }

    private float overMid127(float l, float o) {

        float MID = 255 / 2;

        float d = MID - o;

        return (l - (l * (d / MID)));
    }
    int c = 0;
    int i = 0;

    private int Mozik(int sun, int dog) { // uses min() && AB = BA


        if (i++ % 10 == 0) {
            c = sun;
        }

        return color(red(c), green(c), blue(c));
    }

    private int SAEHardLight(int sun, int dog) { // uses min() && AB = BA
        float rC, gC, bC;

        float rSun = red(sun);
        float gSun = green(sun);
        float bSun = blue(sun);

        float rDog = red(dog);
        float gDog = green(dog);
        float bDog = blue(dog);

        rC = overMid127(rDog, rSun);  // the minimum red from zat px
        gC = overMid127(gDog, gSun);  // the minimum green from zat px
        bC = overMid127(bDog, bSun);  // the minimum blue from zat px

        constrain(rC, 0, 255);
        constrain(gC, 0, 255);
        constrain(bC, 0, 255);

        return color(rC, gC, bC);
    }

    private int SAEOvarlay(int sun, int dog) { // uses min() && AB = BA
        float rC, gC, bC;

        float rSun = red(sun);
        float gSun = green(sun);
        float bSun = blue(sun);

        float rDog = red(dog);
        float gDog = green(dog);
        float bDog = blue(dog);

        rC = overMid127(rSun, rDog);  // the minimum red from zat px
        gC = overMid127(gSun, gDog);  // the minimum green from zat px
        bC = overMid127(bSun, bDog);  // the minimum blue from zat px

        constrain(rC, 0, 255);
        constrain(gC, 0, 255);
        constrain(bC, 0, 255);

        return color(rC, gC, bC);
    }

    private int SAEDarken(int sun, int dog) { // uses min() && AB = BA
        float rC, gC, bC;

        float rSun = red(sun);
        float gSun = green(sun);
        float bSun = blue(sun);

        float rDog = red(dog);
        float gDog = green(dog);
        float bDog = blue(dog);

        rC = min(rSun, rDog);  // the minimum red from zat px
        gC = min(gSun, gDog);  // the minimum green from zat px
        bC = min(bSun, bDog);  // the minimum blue from zat px

        constrain(rC, 0, 255);
        constrain(gC, 0, 255);
        constrain(bC, 0, 255);

        return color(rC, gC, bC);
    }

    private int SAELighten(int sun, int dog) { // uses max() && AB = BA
        float rC, gC, bC;

        float rSun = red(sun);
        float gSun = green(sun);
        float bSun = blue(sun);

        float rDog = red(dog);
        float gDog = green(dog);
        float bDog = blue(dog);

        rC = max(rSun, rDog);  // the minimum red from zat px
        gC = max(gSun, gDog);  // the minimum green from zat px
        bC = max(bSun, bDog);  // the minimum blue from zat px

        constrain(rC, 0, 255);
        constrain(gC, 0, 255);
        constrain(bC, 0, 255);

        return color(rC, gC, bC);
    }
}

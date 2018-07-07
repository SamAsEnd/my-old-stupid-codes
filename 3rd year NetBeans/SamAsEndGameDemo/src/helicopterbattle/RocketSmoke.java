package helicopterbattle;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Rocket smoke.
 * Use: create object of this class then initialize it with Initialize method.
 * 
 * @author www.gametutorial.net
 */

public class RocketSmoke {
    
    // Coordinates of this rocket smoke.
    private int xCoordinate;
    private int yCoordinate;
    
    // How long will this smoke be visible.
    public long smokeLifeTime;
    
    // For calculating how long this smoke exists.
    public long timeOfCreation;
    
    // Image of smoke. Image is loaded and set in Game class in LoadContent() method.
    public static BufferedImage smokeImg;
    
    // Smoke will slowly disappear and this holds how much of smoke is visible.
    public float imageTransparency;
    
    /**
     * Initialize object.
     * 
     * @param xCoordinate X coordinate of this piece of rocket smoke.
     * @param yCoordinate Y coordinate of this piece of rocket smoke.
     * @param gameTime The current elapsed game time in nanoseconds.
     * @param smokeLifeTime How long must the smoke be drawn on a screen?
     * @param image Image of rocket smoke.
     */
    public void Initialize(int xCoordinate, int yCoordinate, long gameTime, long smokeLifeTime)
    {
        this.timeOfCreation = gameTime;
        
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        this.smokeLifeTime = smokeLifeTime;
                
        this.imageTransparency = 1.0f;
    }
    
    
    /**
     * Sets new transparency for rocket smoke image.
     * Older the smoke, more transparent is image of smoke.
     * 
     * @param gameTime The current elapsed game time in nanoseconds.
     */
    public void updateTransparency(long gameTime){
        long currentLifeTime = gameTime - timeOfCreation;
        
        int currentLTInPercentages = (int)(currentLifeTime * 100 / smokeLifeTime);
        currentLTInPercentages = 100 - currentLTInPercentages;
        float rSmokeTransparency = 1.0f * (currentLTInPercentages * 0.01f);

        if(rSmokeTransparency > 0 )
            imageTransparency = rSmokeTransparency;
    }
    
    /**
     * Checks if rocket smoke is old enough to remove it.
     * 
     * @param gameTime The current elapsed game time in nanoseconds.
     * @return True if the smoke should be removed, false otherwise.
     */
    public boolean didSmokeDisapper(long gameTime){
        long currentLifeTime = gameTime - timeOfCreation;
        
        if(currentLifeTime >= smokeLifeTime)
            return true;
        else
            return false;
    }
    
    
    /**
     * Draws a piece of a rocket smoke to the screen.
     * 
     * @param g2d Graphics2D
     */
    public void Draw(Graphics2D g2d)
    {
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, imageTransparency));
        
        // While smoke is disappearing (imageTransparency), it also expanding.
        float imageMultiplier = 2 - imageTransparency; // We will multiply smoke image with imageMultiplier so that will slowly become bigger.
        int newImageWidth = (int)(smokeImg.getWidth() * imageMultiplier);
        int newImageHeight = (int)(smokeImg.getHeight() * imageMultiplier);
        int newImageYCoordinate = (int)(smokeImg.getHeight()/2 * (1-imageTransparency)); // We will set new y coordinate of smoke so that its stays in center behind the rocket.
        g2d.drawImage(smokeImg, xCoordinate, yCoordinate - newImageYCoordinate, newImageWidth, newImageHeight, null);
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    }
}

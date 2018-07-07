package helicopterbattle;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Rocket.
 * Use: create object of this class then initialize it with Initialize method.
 * 
 * @author www.gametutorial.net
 */

public class Rocket {
    
    // Time that must pass before another rocket can be fired.
    public final static long timeBetweenNewRockets = Framework.secInNanosec / 4;
    public static long timeOfLastCreatedRocket = 0;
    
    // Damage that is made to an enemy helicopter when it is hit with a rocket.
    public static int damagePower = 100;
    
    // Rocket position
    public int xCoordinate;
    public int yCoordinate;
    
    // Moving speed and also direction. Rocket goes always straight, so we move it only on x coordinate.
    private double movingXspeed;
    
    // Life time of current piece of rocket smoke.
    public long currentSmokeLifeTime;

    // Image of rocket. Image is loaded and set in Game class in LoadContent() method.
    public static BufferedImage rocketImg;
    

    /**
     * Set variables and objects for this class.
     */
    public void Initialize(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        this.movingXspeed = 23;
        
        this.currentSmokeLifeTime = Framework.secInNanosec / 2;
    }
    
    
    /**
     * Checks if the rocket is left the screen.
     * 
     * @return true if the rocket is left the screen, false otherwise.
     */
    public boolean isItLeftScreen()
    {
        if(xCoordinate > 0 && xCoordinate < Framework.frameWidth) //Rocket moves only on x coordinate so we don't need to check y coordinate.
            return false;
        else
            return true;
    }
    
    
    /**
     * Moves the rocket.
     */
    public void Update()
    {
        xCoordinate += movingXspeed;
    }
    
    
    /**
     * Draws the rocket to the screen.
     * 
     * @param g2d Graphics2D
     */
    public void Draw(Graphics2D g2d)
    {
        g2d.drawImage(rocketImg, xCoordinate, yCoordinate, null);
    }
}

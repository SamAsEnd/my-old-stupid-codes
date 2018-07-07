/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopterbattle;

import java.awt.Point;

/**
 *
 * @author Sam As End
 */
public class SamAsEndBullet extends Bullet{

    public static int damagePower = 80;
    
    
    public SamAsEndBullet(int xCoordinate, int yCoordinate, Point mousePosition) {
        super(xCoordinate, yCoordinate, mousePosition);
    }
    
}

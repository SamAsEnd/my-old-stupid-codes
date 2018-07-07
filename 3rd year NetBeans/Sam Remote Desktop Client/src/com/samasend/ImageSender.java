/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author SamAsEnd
 */
public class ImageSender extends Thread {

    private Robot robot;
    private Rectangle rectangle;
    private OutputStream outputStream;

    public ImageSender(Robot robot, Rectangle rectangle, OutputStream outputStream) {
        this.robot = robot;
        this.rectangle = rectangle;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        while (true) {
            BufferedImage image = robot.createScreenCapture(rectangle);
            //Image scaledInstance = image.getScaledInstance((int) (image.getWidth() * 0.5), (int) (image.getHeight() * 0.5), Image.SCALE_FAST);
            BufferedImage bi = new BufferedImage((int) (image.getWidth() * 0.5), (int) (image.getHeight() * 0.5), BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();
            g.drawImage(/*scaledInstance*/image, 0, 0, null);
            g.dispose();
            try {
                ImageIO.write(bi, "PNG", outputStream);
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
    }

    /**
     * @return the robot
     */
    public Robot getRobot() {
        return robot;
    }

    /**
     * @return the rectangle
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * @return the outputStream
     */
    public OutputStream getOutputStream() {
        return outputStream;
    }

    /**
     * @param robot the robot to set
     */
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    /**
     * @param rectangle the rectangle to set
     */
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * @param outputStream the outputStream to set
     */
    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}

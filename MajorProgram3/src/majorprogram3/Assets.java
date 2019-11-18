/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.image.ImageView;

/**
 *
 * @author nzing
 */
public class Assets extends ImageView implements Animation{
    private double speed;
    private double direction;
    private double power;
    private double parentWidth;
    private double parentHeight;
    
    public Assets(){
        this.speed = 10;
        this.direction = 0;
        this.power = 5;
        this.parentWidth = 900;
        this.parentHeight = 500;
    }
    public Assets(double speed, double direction, double power, double pWidth, double pHeight){
        this.speed = speed;
        this.direction = direction;
        this.power = power;
        this.parentWidth = pWidth;
        this.parentHeight = pHeight;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        
        this.direction = direction;
    }

    /**
     * @return the power
     */
    public double getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * @return the parentWidth
     */
    public double getParentWidth() {
        return parentWidth;
    }

    /**
     * @param parentWidth the parentWidth to set
     */
    public void setParentWidth(double parentWidth) {
        this.parentWidth = parentWidth;
    }

    /**
     * @return the parentHeight
     */
    public double getParentHeight() {
        return parentHeight;
    }

    /**
     * @param parentHeight the parentHeight to set
     */
    public void setParentHeight(double parentHeight) {
        this.parentHeight = parentHeight;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

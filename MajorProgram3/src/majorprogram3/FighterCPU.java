/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author nzing
 */
public class FighterCPU extends Assets {
    private Image fighter1 =new Image("file:Image2.png");;
    private Rectangle2D viewRectangle2D = new Rectangle2D(1571,0,1731,245);
    private Rectangle2D viewRectangle2D2 = new Rectangle2D(160,231,191,245);
    
    public FighterCPU(FightingStage fightingStage){
        //fighter1 =new Image("file:Image1.png");
        this.setImage(fighter1);
        //viewRectangle2D = new Rectangle2D(0,0,165,193);
        this.setViewport(viewRectangle2D);
        this.setLayoutX(540);
        this.setLayoutY(255);
        fightingStage.getChildren().add(this);

    }
    public void Fight(){
        this.setViewport(viewRectangle2D2);
        
        AnimationTimer timer = new AnimationTimer() {
            private long previous =0;
            @Override
            public void handle(long now) {
                //System.out.println("g");
                if(previous ==0){
                    previous=now;
                } else if(now -previous >=1e+9){
                    SecondImage();
                    previous=0;
                }
            }
        };
        timer.start();
                 
        setDirection(-1);
        setSpeed(30);
        
    }
    public void SecondImage(){
        this.setViewport(viewRectangle2D);
    }
    @Override
    public void move(){

        double newX = this.getX() + getSpeed() * getDirection();
        if(newX<-620){
            this.setX(-620);
        }else if(newX>135){
            this.setX(135);
            
        } else {
        this.setX( newX );
        }
    }
       
}

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
public class Fighter extends Assets {
    private final Image fighter1=new Image("file:Image1.png");
    private Rectangle2D viewRectangle2D = new Rectangle2D(0,0,165,193);
    private Rectangle2D viewRectangle2D2 = new Rectangle2D(603,305,288,294);//388,305,603,494
    
    public Fighter(FightingStage fightingStage){
        //fighter1 =new Image("file:Image1.png");
        this.setImage(fighter1);
        viewRectangle2D = new Rectangle2D(0,0,165,193);
        this.setViewport(viewRectangle2D);
        this.setLayoutX(120);
        this.setLayoutY(295);
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
                } else if(now -previous >=1e+9 / 2){
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
        //this.setViewport(viewRectangle2D);     
        double newX = this.getX() + getSpeed() * getDirection();
        if(newX<-250){
            this.setX(-250);
        }else if(newX>this.getParentHeight()){
            this.setX(this.getParentHeight());
            
        } else {
        this.setX( newX );
        }
    }
}

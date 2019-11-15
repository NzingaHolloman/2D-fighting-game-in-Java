/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author nzing
 */
public class Fighter extends Assets {
    private final Image fighter1;
    private Rectangle2D viewRectangle2D;
    private Rectangle2D viewRectangle2D2;
    
    public Fighter(FightingStage fightingStage){
        fighter1 =new Image("file:Image1.png");
        this.setImage(fighter1);
        viewRectangle2D = new Rectangle2D(0,0,165,193);
        this.setViewport(viewRectangle2D);
        this.setLayoutX(120);
        this.setLayoutY(295);
        fightingStage.getChildren().add(this);
        
     
    }
    public void Fight(){
        
    }
    public void Move(){
        
    }
}

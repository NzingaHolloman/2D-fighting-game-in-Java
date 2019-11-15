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
public class FighterCPU extends Assets {
    private  Image fighter2;
    private Rectangle2D viewRectangle2D;
    private Rectangle2D viewRectangle2D2;
    
    public FighterCPU(FightingStage fightingStage){
        fighter2 =new Image("file:Image2.png");
        this.setImage(fighter2);
        viewRectangle2D2 = new Rectangle2D(1571,0,1731,245);
        this.setViewport(viewRectangle2D2);
        this.setLayoutX(540);
        this.setLayoutY(255);
        fightingStage.getChildren().add(this);
    }
    public void Fight(){
        
    }
    public void Move(){
        
    }
}

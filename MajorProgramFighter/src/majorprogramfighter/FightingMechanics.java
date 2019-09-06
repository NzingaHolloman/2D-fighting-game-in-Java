/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogramfighter;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author wedun
 */
public class FightingMechanics extends HBox{
    private static GameInterface gameInterface;
    private static Rectangle playerHealth;
    private static Rectangle cpuHealth;
    private static int originalHealth;
    private static Label timer;
    int timerValue;
    
    public FightingMechanics(FightingStage fightingStage, GameInterface gameInterface){
        timerValue = 99;
        timer = new Label();
        timer.setPrefWidth(originalHealth);
        timer.setText(Integer.toString(timerValue));
        originalHealth=150;
        this.gameInterface = gameInterface;
        playerHealth = new Rectangle(originalHealth,30);
        playerHealth.setFocusTraversable(false);
        playerHealth.setFill(Color.BLUE);
        cpuHealth = new Rectangle (originalHealth,30);
        cpuHealth.setFocusTraversable(false);
        cpuHealth.setFill(Color.BLACK);
        
        this.getChildren().addAll(playerHealth,timer,cpuHealth);
        this.setSpacing(150);
        gameInterface.setTop(this);
    }
    
    public static void attackTheEnenmy(Assets playerControlledFighter, Assets computerControlledFighter, Rectangle playerDamage){
        if(playerControlledFighter.getBoundsInParent().intersects(computerControlledFighter.getBoundsInParent())){
            playerDamage.setWidth(playerDamage.getWidth()-10);
        }
        
    }
    
    public Rectangle getPlayerHealth(){
        return playerHealth;
    }
    public Rectangle getCPUHealth(){
        return cpuHealth;
    }
    
    public void resetHealth(){
        this.playerHealth.setWidth(originalHealth);
        this.cpuHealth.setWidth(originalHealth);
    }  
}

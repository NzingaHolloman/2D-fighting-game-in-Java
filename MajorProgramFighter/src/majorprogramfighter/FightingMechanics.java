/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogramfighter;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private static int originalTimer;
    private static TextField timer;
    private CountDown countDown;
    int timerValue;
    
    public FightingMechanics(FightingStage fightingStage, GameInterface gameInterface){
        originalTimer =99;
        timerValue = originalTimer;
        timer = new TextField();
        timer.setAlignment(Pos.CENTER);
        timer.setFocusTraversable(false);
        timer.setText(Integer.toString(timerValue));
        originalHealth=400;
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
        countDown=new CountDown();
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
    
    public void startCountDown(){
        countDown.start();
    }
    public void stopCountDown(){
        countDown.stop();
    }
    public void resetTimer(){
        this.timerValue=originalTimer+1;
    }
    
    public int getTimerValue(){
        return timerValue;
    }
    
    private class CountDown extends AnimationTimer{
        long countPrevious=0;
        @Override
        public void handle(long now) {
            if(countPrevious==0){
                countPrevious=now;
            }
            if(now-countPrevious>1000000000){
                timerValue--;
                timer.setText(Integer.toString(timerValue));
                countPrevious=now;
            }
        }
        
    }
    
}

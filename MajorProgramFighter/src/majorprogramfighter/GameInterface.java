/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogramfighter;

import java.util.Optional;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author wedun
 */
public class GameInterface extends BorderPane{
    private PlayerControlledFighter USERFighter;
    private ComputerControlledFighter CPUFighter;
    private FightingStage fightingStage;
    private gameInterfaceHandler keyEvent;
    private FighterAnimation fighterAnimation;
    private FightingMechanics fightingMechanics;
    private ControlPanel controlPanel;
        private Rectangle cpuHealth;
        private Rectangle playerHealth;
    
    public GameInterface(){
        fightingStage = new FightingStage(this);
        USERFighter = new PlayerControlledFighter(fightingStage);
        CPUFighter = new ComputerControlledFighter(fightingStage);
        keyEvent = new gameInterfaceHandler();
        fighterAnimation = new FighterAnimation();
        fightingMechanics = new FightingMechanics(fightingStage,this);
        controlPanel = new ControlPanel(this);
        cpuHealth =fightingMechanics.getCPUHealth();
        playerHealth=fightingMechanics.getPlayerHealth();
        
        AddFunctionality();
        ButtonFTN();
    }
       public void ButtonFTN(){
        controlPanel.getStartGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getPlayerControlledFighter().setOnKeyPressed(keyEvent);
                fighterAnimation.start();
                fightingMechanics.startCountDown();
            }
        });
        
        controlPanel.getRestartButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               USERFighter.setX(USERFighter.getOriginalPosition());
               CPUFighter.setX(CPUFighter.getOriginalPosition());
               fightingMechanics.resetHealth();
            }
        });
        
        controlPanel.getExitGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                USERFighter.setSpeed(0.0);
                CPUFighter.setSpeed(0.0);
                fighterAnimation.stop();
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Existing 2D Fighter");
                alert.setHeaderText("Last Chance");
                alert.setContentText("Are you sure?");
                
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK){
                    System.exit(-1);
                }
                else{
                    USERFighter.setSpeed(10.0);
                    CPUFighter.setSpeed(10.0);
                    fighterAnimation.start();
                }

            }
        });
    }
       
    
    public void AddFunctionality(){
       
    }
    
    public void gameOver(){
        if((cpuHealth.getWidth() < 1)||(playerHealth.getWidth()<1)){
            System.exit(-1);
        }
    }
    
    private class gameInterfaceHandler implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent event) {
            switch(event.getCode()){
                case LEFT:
                    USERFighter.setDirection(180.0);
                    USERFighter.move();
                    break;
                case RIGHT:
                    USERFighter.setDirection(0.0);
                    USERFighter.move();
                    break;
                case SPACE:
                    USERFighter.fight();
                    fightingMechanics.attackTheEnenmy(USERFighter,CPUFighter,playerHealth);
                    gameOver();
                    break;
            }
        }   
    }
    
    private class FighterAnimation extends AnimationTimer{
        long previous = 0;
        long enemyPrevious =0;
        @Override
        public void handle(long now) {
            if((previous==0)){
                previous=now;
            }
            else if((now-previous) > 310000000){
                USERFighter.verifyFighter();
                previous=now;
            } 
            else if((now-enemyPrevious) > 990000000){
                CPUFighter.verifyFighter();
                enemyPrevious=now;
            }
            else if((now-enemyPrevious)> 720000000){
                CPUFighter.performAttack();
                fightingMechanics.attackTheEnenmy(CPUFighter,USERFighter,playerHealth);
            }
            else if((now-enemyPrevious)>520000000){
                CPUFighter.movement();
            }
        }
    }
    
    public FightingStage getFightingStage(){
        return this.fightingStage;
    }
    public PlayerControlledFighter getPlayerControlledFighter(){
        return USERFighter;
    }
}

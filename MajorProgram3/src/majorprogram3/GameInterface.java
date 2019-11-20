/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author nzing
 */
public  class GameInterface extends BorderPane {
    private Fighter fighters;
    private FighterCPU cpu;
    private FightingStage fightingStage;
    private ControlPanel controlPanel;
    private MoveFighter moveFighter;
    private FightingMechanic fightingMechanic;
   
    
    public GameInterface() throws FileNotFoundException{
        
        controlPanel = new ControlPanel();
        
        
        this.setBottom(controlPanel); 
        
        this.fightingStage = new FightingStage(this);
        this.setCenter(fightingStage);
        moveFighter = new MoveFighter();
        this.fighters = new Fighter(fightingStage);
        this.cpu = new FighterCPU(fightingStage);
        
        this.fightingMechanic = new FightingMechanic(fightingStage);
        this.setTop(fightingMechanic);
        
        MoveFighterCPU();
        
        fighters.setOnKeyPressed(moveFighter);
        
        fighters.setTranslateY(15);
        cpu.setTranslateY(10);
        cpu.setTranslateX(60);
        fighters.setTranslateX(120);
                
    }
    public void MoveFighterCPU(){
        Random rand  = new Random();
        
        AnimationTimer timer = new AnimationTimer() {
            private long previous =0;
            int i = 0; int u = 0;int p = 0;
            @Override
            public void handle(long now) {
                int r = rand.nextInt(3);
                //System.out.println(r);
                if(r == 0 ){
                    p++;
                    if(p>15){
                    System.out.println("1");
                    cpu.setDirection(1);
                    cpu.move();
                    cpu.move();
                    now=0;
                    p=0;
                    }
                }else if(r == 2 ){
                    u++;
                    if(u>45){
                    cpu.Fight();
                    cpu.setDirection(1);
                    cpu.setSpeed(10);
                    u=0;
                    now=0;
                    }
                }else if(r == 1 ){
                    i++;
                    if(i>15){
                        System.out.println("1");
                        cpu.setDirection(-1);
                        cpu.move();
                        cpu.move();
                        cpu.move();           
                        i=0;
                    }
                }
            }
        };
        timer.start();
    }
    public void GameOver() {
        
    }
    public Fighter getFighter(){
        return fighters;
    }
    public class MoveFighter implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent event) {
            if(event.getCode() == KeyCode.LEFT){
                System.out.println("1");
                fighters.setDirection(-1);
                fighters.move();
            }
            else if(event.getCode() == KeyCode.RIGHT){
                System.out.println("r");
                fighters.setDirection(1);
                fighters.move();
            }else if(event.getCode() == KeyCode.SPACE){
                fighters.Fight();
                fighters.setDirection(1);
                fighters.setSpeed(30);
            }
        }
        
    }
}

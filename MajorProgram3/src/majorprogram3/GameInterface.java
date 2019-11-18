/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileNotFoundException;
import java.util.Timer;
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
    //include alll animation Timers
    
    public GameInterface() throws FileNotFoundException{
        
        controlPanel = new ControlPanel();
        
        
        this.setBottom(controlPanel); 
        
        this.fightingStage = new FightingStage(this);
        this.setCenter(fightingStage);
        moveFighter = new MoveFighter();
        this.fighters = new Fighter(fightingStage);
        this.cpu = new FighterCPU(fightingStage);
        
        
        fighters.setOnKeyPressed(moveFighter);
        
        fighters.setTranslateY(15);
        cpu.setTranslateY(10);
        cpu.setTranslateX(60);
        fighters.setTranslateX(120);
                
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
                //Timer t = new Timer();
                //t.start();
                fighters.setDirection(1);
                fighters.setSpeed(30);
                //fighters.move();
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}

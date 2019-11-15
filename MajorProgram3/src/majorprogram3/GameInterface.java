/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileNotFoundException;
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
    //include alll animation Timers
    
    public GameInterface() throws FileNotFoundException{
        this.fightingStage = new FightingStage(this);
        //this.setBackground(fightingStage.returnBackground());
        this.setCenter(fightingStage);
        
        //this.setBackground(fightingStage.getBackground());
        this.fighters = new Fighter(fightingStage);
        this.cpu = new FighterCPU(fightingStage);
        controlPanel = new ControlPanel();
        this.setBottom(controlPanel);
    }
    public void GameOver() {
        
    }
}

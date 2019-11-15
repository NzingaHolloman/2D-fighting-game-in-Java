/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
/**
 *
 * @author nzing
 */
public class ControlPanel extends HBox{
    private Button startGame;
    private Button restartGame;
    private Button exitGame;
    
    public ControlPanel(){
       startGame = new Button("Start");
       restartGame = new Button("Restart");
       exitGame = new Button("Exit");
       
       this.setSpacing(30);
       this.setPadding(new Insets(0,300,0,300));
       this.setPrefSize(900, 20);
       this.getChildren().addAll(startGame, restartGame, exitGame);
    }

    /**
     * @return the startGame
     */
    public Button getStartGame() {
        return startGame;
    }

    /**
     * @return the restartGame
     */
    public Button getRestartGame() {
        return restartGame;
    }

    /**
     * @return the exitGame
     */
    public Button getExitGame() {
        return exitGame;
    }
            
}

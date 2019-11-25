/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static majorprogram3.GameInterface.timer;
import static majorprogram3.GameInterface.timer2;
import static majorprogram3.GameInterface.timerValue;
import static majorprogram3.GameInterface.red1;
import static majorprogram3.GameInterface.red2;
import static majorprogram3.GameInterface.playerHealth2;
import static majorprogram3.GameInterface.cpuHealth2;
import static majorprogram3.GameInterface.fighters;
import static majorprogram3.GameInterface.cpu;

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
       
        startGame.setFocusTraversable(false);
        restartGame.setFocusTraversable(false);
        exitGame.setFocusTraversable(false);
       
        startGame.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                timerValue = 60;
                red1 = 0;
                red2 = 0;
                playerHealth2.setWidth(0);
                cpuHealth2.setWidth(0);
                fighters.setX(0);
                cpu.setX(0);
                timer.start();
                timer2.start();
            }
        });
        restartGame.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                timer.stop();
                timer2.stop();
                timerValue = 60;
                red1 = 0;
                red2 = 0;
                playerHealth2.setWidth(0);
                cpuHealth2.setWidth(0);
                fighters.setX(0);
                cpu.setX(0);
                
                timer.start();
                timer2.start();
            }
        });
        exitGame.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
       
       
       Pane pane = new Pane();
       pane.getChildren().addAll(startGame, restartGame, exitGame);
       this.setSpacing(30);
       this.setPadding(new Insets(0,300,20,300));
       this.setPrefSize(900, 4);
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

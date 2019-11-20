/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileNotFoundException;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author nzing
 */
public class FightingMechanic extends GridPane{
    private GameInterface gameInterface;
    private FightingStage fightingStage;
    private Rectangle playerHealth;
    private Rectangle cpuHealth;
    private TextField time = new TextField();
    private int timerValue;
    private Label playerName = new Label("Captain America");
    private Label cpuName = new Label("Black Widow");;
    private VBox vbox = new VBox();
    private VBox vboxCPU = new VBox();
    
    public FightingMechanic(FightingStage fightingStage){
        playerHealth = new Rectangle(400,50);
        playerHealth.setFill(Color.GREEN );
        playerHealth.setStroke(Color.BLACK);
        vbox.getChildren().addAll(playerName, playerHealth);
        
        cpuHealth = new Rectangle(400,50);
        cpuHealth.setFill(Color.GREEN );
        cpuHealth.setStroke(Color.BLACK);
        vboxCPU.getChildren().addAll(cpuName,cpuHealth);
        
        timerValue = 60;
        
        time.setPrefColumnCount(100);
        time.setPrefHeight(70);
        time.setEditable(false);
        time.setText(Integer.toString(timerValue));
        
        time.setFocusTraversable(false);
       
        //time.setPrefColumnCount(15);
        
        AnimationTimer timer = new AnimationTimer() {
            //private int 
            private long previous =0;
            @Override
            public void handle(long now) {
                //System.out.println("g");
                if(previous ==0){
                    previous=now;
                }else if(now -previous >=1e+9){
                    if(timerValue == 0){
                        time.setText("Game Over!");
                        //now = 0;
                    }else{
                        timerValue= timerValue-1;
                        time.setText(Integer.toString(timerValue));
                        previous = 0;
                    }
                    
                }
                
            }
        };
        timer.start();
        
        this.add(vbox, 0, 0);
        this.add(time, 1, 0);
        this.add(vboxCPU, 2, 0);
        //this.add()
        
        fightingStage.getChildren().add(this);
                
    }
}

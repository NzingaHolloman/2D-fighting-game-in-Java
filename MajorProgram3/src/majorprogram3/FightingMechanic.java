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
    private Rectangle playerHealth;
    private Rectangle cpuHealth;
    private Rectangle playerHealth2;//= new Rectangle(400,50);
    private Rectangle cpuHealth2;//= new Rectangle(400,50);
    private TextField time = new TextField();
    private int timerValue;
    private Label playerName = new Label("Captain America");
    private Label cpuName = new Label("Black Widow");;
    private VBox vbox = new VBox();
    private VBox vboxCPU = new VBox();
    private VBox vbox2 = new VBox();
    private VBox vboxCPU2 = new VBox();
    private int red1 = 0;
    private int red2 = 0;
    
    public FightingMechanic(FightingStage fightingStage){
        playerHealth = new Rectangle(400,50);
        playerHealth.setId("Black Widow");
        playerHealth.setFill(Color.GREEN );
        playerHealth.setStroke(Color.BLACK);
        vbox.getChildren().addAll(playerHealth,playerName);
        
        cpuHealth = new Rectangle(400,50);
        cpuHealth.setFill(Color.GREEN );
        cpuHealth.setStroke(Color.BLACK);
        vboxCPU.getChildren().addAll(cpuHealth,cpuName);
        
        playerHealth2 = new Rectangle(getRed1(),50);
        playerHealth2.setFill(Color.RED );
        playerHealth2.setStroke(Color.BLACK);
        vbox2.getChildren().addAll(playerHealth2,playerName);
        
        cpuHealth2 = new Rectangle(getRed2(),50);
        cpuHealth2.setFill(Color.RED );
        cpuHealth2.setStroke(Color.BLACK);
        vboxCPU2.getChildren().addAll(cpuHealth2,cpuName);
        
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
        this.add(vbox2, 0, 0);
        this.add(time, 1, 0);
        this.add(vboxCPU, 2, 0);
        this.add(vboxCPU2, 2, 0);
        //this.add()
        
        fightingStage.getChildren().add(this);
                
    }

    /**
     * @return the red1
     */
    public int getRed1() {
        return red1;
    }

    /**
     * @param red1 the red1 to set
     */
    public void setRed1() {
        red1 = red1+10;
    }

    /**
     * @return the red2
     */
    public int getRed2() {
        return red2;
    }

    /**
     * @param red2 the red2 to set
     */
    public void setRed2() {
        red2 = red2+10;
    }
    
}

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    
    private TextField time = new TextField();
    private int timerValue;
    private Label playerName = new Label("Captain America");
    private Label cpuName = new Label("Black Widow");;
    private VBox vbox = new VBox();
    private VBox vboxCPU = new VBox();
    private VBox vbox2 = new VBox();
    private VBox vboxCPU2 = new VBox();
    private int red1;
    private int red2;
   
    private GridPane FightingMechanic;
    private Rectangle playerHealth2;
    private Rectangle cpuHealth2;
    
    public GameInterface() throws FileNotFoundException{
        
        controlPanel = new ControlPanel();
        
        
        this.setBottom(controlPanel); 
        
        this.fightingStage = new FightingStage(this);
        this.setCenter(fightingStage);
        moveFighter = new MoveFighter();
        this.fighters = new Fighter(fightingStage);
        this.cpu = new FighterCPU(fightingStage);
        
        //this.fightingMechanic = new FightingMechanic(fightingStage);
        //this.setTop(fightingMechanic);
        
        MoveFighterCPU();
        
        fighters.setOnKeyPressed(moveFighter);
        
        fighters.setTranslateY(15);
        cpu.setTranslateY(10);
        cpu.setTranslateX(60);
        fighters.setTranslateX(120);
        
        
        
        FightingMechanic = new GridPane();
        red1 = 0;
        red2 = 0;
        Rectangle playerHealth = new Rectangle(400,50);
        playerHealth.setId("Black Widow");
        playerHealth.setFill(Color.GREEN );
        playerHealth.setStroke(Color.BLACK);
        vbox.getChildren().addAll(playerHealth,playerName);
        
        Rectangle cpuHealth = new Rectangle(400,50);
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
                }else if(now -previous >=1e+9/2){
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
        
        FightingMechanic.add(vbox, 0, 0);
        FightingMechanic.add(vbox2, 0, 0);
        FightingMechanic.add(time, 1, 0);
        FightingMechanic.add(vboxCPU, 2, 0);
        FightingMechanic.add(vboxCPU2, 2, 0);
        this.setTop(FightingMechanic);
    }
    
    public void MoveFighterCPU(){
        Random rand  = new Random();
        
        AnimationTimer timer;
        timer = new AnimationTimer() {
            private long previous =0;
            int i = 0; int u = 0;int p = 0;
            @Override
            public void handle(long now) {
                int r = rand.nextInt(3);
                //System.out.println(r);
                switch (r) {
                    case 0:
                        p++;
                        if(p>10){
                            //System.out.println("1");
                            cpu.setDirection(1);
                            cpu.move();
                            cpu.move();
                            cpu.move();
                            now=0;
                            p=0;
                        }   break;
                    case 2:
                        u++;
                        if(u>45){
                            cpu.Fight();
                            cpu.setDirection(1);
                            cpu.setSpeed(10);
                            u=0;
                            now=0;
                            if(fighters.getX()>=cpu.getX()+250){// && fighters.getX()<=cpu.getX()+200){//&& fighters.getX()<=cpu.getX()-290){
                                //System.out.println("this fighting is woking"+ cpu.getX()+200);
                                //fightingMechanic.setRed2();
                                setRed1();
                            }
                        }       break;
                    case 1:
                        i++;
                        if(i>10){
                            if(fighters.getX()<=cpu.getX()+260){//&& fighters.getX()<=cpu.getX()-290){
                                //System.out.println("this fighting is woking");
                                cpu.setDirection(-1);
                                cpu.move();
                                cpu.move();
                                cpu.move();
                                i=0;
                            }
                            
                        }   break;
                    default:
                        break;
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

                fighters.setDirection(-1);
                fighters.move();
            }
            else if(event.getCode() == KeyCode.RIGHT){
                //System.out.println("r");
                if(fighters.getX()<=cpu.getX()+220){
                    //System.out.println("this fighting is woking");
                    fighters.setDirection(1);
                    fighters.move();
                }
                
            }else if(event.getCode() == KeyCode.SPACE){
                fighters.Fight();
                fighters.setDirection(1);
                fighters.setSpeed(30);
                if(fighters.getX()>=cpu.getX()+190 && fighters.getX()<=cpu.getX()+410){
                    //System.out.println("this fighting is woking");
                    //fightingMechanic.setRed1();
                    setRed2();
                    
                }
            }
        }
        
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
        System.out.println(red1);
        if(red1<=400){
            playerHealth2.setWidth(red1);
        }
        //playerHealth2.setWidth(red1);
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
        System.out.println(red2);
        if(red2<=400){
            cpuHealth2.setWidth(red2);
        }
    }
}

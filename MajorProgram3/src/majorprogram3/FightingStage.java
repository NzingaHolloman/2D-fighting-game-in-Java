/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 *
 * @author nzing
 */
public class FightingStage extends Pane{
    private Background background;
    //private FileInputStream input;
    
    public FightingStage(GameInterface gameinterface) throws FileNotFoundException{
       // BackgroundImage image = getBackground();
        FileInputStream input = null;
          try {
            input = new FileInputStream("leaves.jpg");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FightingStage.class.getName()).log(Level.SEVERE, null, ex);
        }
                  Image image = new Image(input); //Create a image

            BackgroundImage backgroundimage = new BackgroundImage(image,  
                                            BackgroundRepeat.NO_REPEAT,  
                                            BackgroundRepeat.NO_REPEAT,  
                                            BackgroundPosition.DEFAULT,  
                                            BackgroundSize.DEFAULT);

            background = new Background(backgroundimage);
            this.setBackground(background);
    }

    /**
     * @return the background
     */
    public Background returnBackground() {
        return background;
    }
}


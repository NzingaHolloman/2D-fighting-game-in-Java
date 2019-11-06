# Major-Project-3-Fall-2019
Design a 2D fighting game in Java

### **CAUTION : This is not an exhaustive flow chart. These are not exhaustive UMLs. You may need to implement additional class and methods!**

![Project UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/Diagrams/AnimationUML.PNG)

The Animation interface contains a method 'move()' that a class can implement.\
This method will be overwritten, and provide instruction on how to move fighters\
![Animation UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/AnimationUMLUpdated.PNG)

The Asset class extends the ImageView class and implements the Animation interfaces. It contains properties that fighters contain, such as speed, direction, and power\
![Asset UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/AssetUMLUpdated.PNG)

direction is in degrees. Example:\
double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()) );\
double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection()) ;\
this.setX( newX );\
this.setY( newY );\
\
The Fighter class can be implemented in **many ways**\
This is where properties such as sprites, different viewports for animation, and the move() method is overwritten\
![Fighters UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/FightersUMLUpdated.PNG)\
Feel free to use any sprite sheet (google image search 'sprite sheet')\
Use the setViewport(Rectangle2D object) method to isolate individual sprites.

The FightingStage class is a **Pane** where the fighting stage background is imported.\
Utilize this class' constructor to import the fighting stage onto the GameInterface\
![Fighting Stage UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/FightingStageUMLUpdated.PNG)\
Feel free to use any background image you like\
set the width and height of the fighting stage in this class

The GameInterface class is a **BorderPane** where all the elements come together. The fighters are on the stage, the stage is on the game interface. The buttons to start, restart, and exit the game on the game interface, the status, including the players health and time remaining, are also on the game interface.
![Game Interface UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/GameInterfaceUMLUpdated.PNG)\
AnimationTimers work to control certain movements and the combat action of players

The ControlPanel class is a **Hbox** where the button to start, restart, and exit the game are created. This can be implemented in **many ways**\
![Control Panel UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/ControlPanelUMLUpdated.PNG)

The FightingMechanic class is a **GridPane** that can be implemented in **many ways** \
This is where the results of combat are analyzed. This is where:\
  The health is decremented when a player is hit\
  The time left is evaluated\
  Combat is registered\
  Also create a method that prevents fighters from walking through each other.
![Fighting Mechanics UML](https://github.com/NCATCS/Fall_2019_Major_Program_3/blob/master/FightingMechanicsUMLUpdated.PNG) 

Remember : Nodes go on panes, panes go on scenes, scenes go on stages.

## Breakdown: ##

Level 1: Create the FightingStage and GameInterface classes. Import your background image and set the dimensions of your pane. At this level your empty fighting stage should display.(14 points)
\
\
Level 2: Create the Asset and Animation classes. These will be used to animate your fighters.\
Create **your** Fighter(s) class(es). Add your fighters to your fighting stage. At this level, your fighting stage should contain your static fighters.(14 points)
\
\
Level 3: Create the ControlPanel class. Add your start, restart, and exit buttons to your game interface. At this level your game interface should have a fighting stage with two fighters, and the buttons to start, restart, and exit the game.(14 points)
\
\
Level 4: In your GameInterface class. Utilize a KeyEventHandler to animate the character the player will control. At this level you should have a moving character that can attack.(14 points)
\
\
Level 5: Animate the second character, such that it can move and attack without a KeyEventHandler. Create the FightingMechanics class. At this level both characters should be able to move and attack. The health bars and timers should be added to the game interface.(14 points)
\
\
Level 6: Implement a method that wil detect when an attack has landed on a player. There are **many ways** to do this. At this level, when a player is attacked, their health bar should decrease.(14 points)
\
\
Level 7: Implement a method that will detect when the game is over. The conditions for a game over include: \(16 points)
The player's health has reached 0 \
The CPU's health has reached 0\ 
The timer has run out of time.

Extra credit: Add music to the program when the start button is pushed. (Student submitted: 10 points)

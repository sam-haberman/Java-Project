package Characters;

import javax.swing.*;

//This class is the hardest regular enemy
public class HardEnemy{
    //sets the picture of our enemy to this enemy class
    ImageIcon hard = new ImageIcon(this.getClass().getResource("/Images/hardenemy.jpg"));
    //easy enemy attributes
    int strength = 8;
    int defense = 4;
    int health = 60;
    int score = 30;
    int experience = 40;
    //boolean to see if player is running, if true player ran from fight
    boolean run = true;
    //string that holds the difficulty level of the game taken from the GameInfoandLogic.StartWindow combobox
    String diffLevel;

    //constructor for our hard enemy, stats change based on difficulty, easy is the default setting
   public HardEnemy(String d){
       diffLevel = d;
       if (diffLevel.equals("Medium")){
           this.strength = 10;
           this.defense = 5;
           this.health = 70;
           this.score = 40;
       }
       else if (diffLevel.equals("Hard")){
           this.strength = 11;
           this.defense= 6;
           this.health = 80;
           this.score = 60;
       }
   }

    //getters and setters needed for combat operations

    public int getStrength(){ return this.strength;}

    public int getDefense() { return this.defense;}

    public int getHealth() { return this.health;}

    public int getScore() { return this.score;}

    public int getExperience() { return this.experience;}

    public boolean getRun(){return this.run;}

    public ImageIcon getImage(){return this.hard;}

    public void setHealth(int health) {this.health = health;}

    public void setRun(boolean b){this.run = b;}

    //reset health method
    public void resetHealth(){setHealth(60);}

    //method to reset enemeny run boolean back to false if player ran
    public void resetRun(){setRun(false);}
}

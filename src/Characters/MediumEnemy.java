package Characters;

import javax.swing.*;

//This class is the medium enemy the second easiest to defeat. Stats change based on difficulty setting
public class MediumEnemy{

    ImageIcon medium = new ImageIcon(this.getClass().getResource("/Images/mediumenemy.jpg"));
    //easy enemy attributes
    int strength = 5;
    int defense = 2;
    int health = 40;
    int score = 20;
    int experience = 30;
    //boolean to see if player is running, if true player ran from fight
    boolean run = true;
    //String that holds the difficulty level of the game
    String diffLevel;

    //update enemy stats based on difficulty level chosen
    public MediumEnemy(String d){
        diffLevel = d;
        if (diffLevel.equals("Medium")){
            this.strength = 6;
            this.defense = 4;
            this.health = 40;
            this.score = 30;
        }
        else if (diffLevel.equals("Hard")){
            this.strength = 7;
            this.defense=5;
            this.health = 50;
            this.score = 35;
        }
    }

    //getters and setters needed for combat operations

    public int getStrength(){ return this.strength;}

    public int getDefense() { return this.defense;}

    public int getHealth() { return this.health;}

    public int getScore() { return this.score;}

    public int getExperience() { return this.experience;}

    public boolean getRun(){return this.run;}

    public ImageIcon getImage(){return this.medium;}

    public void setHealth(int health) {this.health = health;}

    public void setRun(boolean b){this.run = b;}

    //reset health method
    public void resetHealth(){setHealth(40);}

    //method to reset enemeny run boolean back to false if player ran
    public void resetRun(){setRun(false);}
}

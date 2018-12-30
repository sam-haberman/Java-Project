package Characters;

import javax.swing.*;

//This class is the first enemy and is the easiest (weakest) to defeat
public class EasyEnemy{

    //Picture of easy enemy
    ImageIcon easy = new ImageIcon(this.getClass().getResource("/Images/easyenemy.jpg"));
    //easy enemy attributes
    int strength = 3;
    int defense = 0;
    int health = 20;
    int score = 10;
    int experience = 20;
    //boolean to see if player is running, if true player ran from fight, starts as true
    boolean run = true;
    //String that is the difficulty level of the game
    String diffLevel;

    //update enemy stats based on difficulty level
    public EasyEnemy(String d){
        diffLevel = d;
        if (diffLevel.equals("Medium")){
            this.strength = 4;
            this.defense = 2;
            this.health = 30;
            this.score = 20;
        }
        else if (diffLevel.equals("Hard")){
            this.strength = 5;
            this.defense=2;
            this.health = 35;
            this.score = 25;
        }
    }

    //getters and setters needed for combat operations

    public int getStrength(){ return this.strength;}

    public int getDefense() { return this.defense;}

    public int getHealth() { return this.health;}

    public int getScore() { return this.score;}

    public int getExperience() { return this.experience;}

    public boolean getRun(){return this.run;}

    public ImageIcon getImage(){return this.easy;}

    public void setHealth(int health) {this.health = health;}

    public void setRun(boolean b){this.run = b;}

    //reset health method for after combat or after running
    public void resetHealth(){setHealth(20);}

    //method to reset enemy run boolean back to false if player ran
    public void resetRun(){setRun(false);}
}

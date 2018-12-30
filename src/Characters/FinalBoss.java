package Characters;

import javax.swing.*;
import java.awt.*;

//This class is the final boss and you win the game once you defeat him
public class FinalBoss{
    //Image icon variable for boss picture
    ImageIcon boss;
    //easy enemy attributes
    int strength = 12;
    int defense = 8;
    int health = 100;
    int score = 100;
    int experience = 40;
    //boolean to see if player is running, if true player ran from fight
    boolean run = true;
    //variable that holds the difficulty setting of the game which affects the bosses stats
    String diffLevel;

    //constructor for final boss that assigns the picture and stats based on difficulty level
    public FinalBoss(String d){
        diffLevel = d;
        boss = new ImageIcon(this.getClass().getResource("/Images/finalboss.jpg"));
        Image bossupdate = boss.getImage();
        Image newboss = bossupdate.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        boss = new ImageIcon(newboss);
        if (diffLevel.equals("Medium")){
            this.strength = 13;
            this.defense = 9;
            this.health = 120;
            this.score = 150;
        }
        else if (diffLevel.equals("Hard")){
            this.strength = 18;
            this.defense=14;
            this.health = 200;
            this.score = 400;
        }
    }

    //getters and setters needed for combat operations

    public int getStrength(){ return this.strength;}

    public int getDefense() { return this.defense;}

    public int getHealth() { return this.health;}

    public int getScore() { return this.score;}

    public boolean getRun(){return this.run;}

    public ImageIcon getImage(){return this.boss;}

    public void setHealth(int health) {this.health = health;}

    public void setRun(boolean b){this.run = b;}

    //reset health method
    public void resetHealth(){setHealth(100);}

    //method to reset enemeny run boolean back to false if player ran
    public void resetRun(){setRun(false);}
}

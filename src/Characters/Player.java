package Characters;

import javax.swing.*;
import java.awt.*;

//This class holds the Player character class and all its stats and methods
public class Player {
    //These are the attributes that are being tracked for the user character throughout the game
    //starting attributes
    //Health attribute, player loses if this reaches 0
    private int playerHealth = 100;
    //Strength attribute, assess how strong the user is and influences the damage they can do
    private int playerStrength;
    //Defense attribute, assess how much less damage a player can take
    private int playerDefense;
    //How much energy the player has, moving on the GameInfoandLogic.GameBoard costs energy and the player loses if this reaches 0
    private int energy = 100;
    //The name attribute keeps track of the users character name
    private String name;
    //Create belt arrays (level progression)
    private String[] belts = {"White", "Yellow", "Blue", "Black"};
    //Create beltNum for switch case for updating belt picture
    private int beltNum = 0;
    //The belt attribute keeps track of the players belt rating(analogous to a level)
    private String belt = belts[beltNum];
    //Experience attribute, when this value hits 100 it resets to 0 and the player grows stronger and their belt increases
    private int experience = 0;
    //Score attribute keeps track of the players score and when the game ends it will be recorded and added to High Score list
    //if it is a high score
    private int score = 0;
    //Avatar variable keeps track of what avatar portrait the user chose
    private ImageIcon avatar;
    //Belt picture array creation
    private ImageIcon[] beltPics = new ImageIcon[4];
    //Image variables for each belt
    ImageIcon wBelt;
    ImageIcon yBelt;
    ImageIcon bluBelt;
    ImageIcon blaBelt;

    //array that keeps track of tiles that player has visited so that they only interact with new tiles
    boolean tilesVisited[][] = new boolean[10][10];


    //Create Player constructor based on starting settings, as well as generate images for belt
    public Player(String name, ImageIcon avatar, int playerStrength){
        this.name = name;
        this.avatar = avatar;
        this.playerStrength = playerStrength;
        this.playerDefense = 10 - playerStrength;

        //Fixing Belt Pictures and adding them to Beltpicture ImageIcon array
        wBelt = new ImageIcon(this.getClass().getResource("/Images/white belt.png"));
        Image whiteBelt = wBelt.getImage();
        Image newWhiteBelt = whiteBelt.getScaledInstance(150,100, Image.SCALE_SMOOTH);
        beltPics[0] = new ImageIcon(newWhiteBelt);

        yBelt = new ImageIcon(this.getClass().getResource("/Images/yellow belt.png"));
        Image yellowBelt = yBelt.getImage();
        Image newYellowBelt = yellowBelt.getScaledInstance(150,100, Image.SCALE_SMOOTH);
        beltPics[1] = new ImageIcon(newYellowBelt);

        bluBelt = new ImageIcon(this.getClass().getResource("/Images/blue belt.png"));
        Image blueBelt = bluBelt.getImage();
        Image newBlueBelt = blueBelt.getScaledInstance(150,100, Image.SCALE_SMOOTH);
        beltPics[2] = new ImageIcon(newBlueBelt);

        blaBelt = new ImageIcon(this.getClass().getResource("/Images/black belt.png"));
        Image blackBelt = blaBelt.getImage();
        Image newBlackBelt = blackBelt.getScaledInstance(150,100, Image.SCALE_SMOOTH);
        beltPics[3] = new ImageIcon(newBlackBelt);
    }

    //Belt Update Method, changes belt picture to match belt level

    public ImageIcon updateBelt(){
        ImageIcon belt = new ImageIcon();
        switch (beltNum){
            case 0:
                belt = beltPics[0];
                break;
            case 1:
                belt = beltPics[1];
                break;
            case 2:
                belt = beltPics[2];
                break;
            case 3:
                belt = beltPics[3];
                break;
            default:
                belt = beltPics[3];
                break;
        }
        return belt;
    }

    //Getter and Setter Methods for all attributes

    public int getPlayerHealth(){
        return this.playerHealth;
    }

    public int getPlayerStrength(){
        return this.playerStrength;
    }

    public int getPlayerDefense(){
        return this.playerDefense;
    }

    public int getEnergy(){
        return this.energy;
    }

    public int getExperience(){
        return this.experience;
    }

    public int getScore(){
        return this.score;
    }

    public int getbeltNum(){
        return this.beltNum;
    }

    public String getName(){
        return this.name;
    }

    public ImageIcon getAvatar() {return this.avatar;}

    //returns boolean value of tile
    public boolean checkTile(int i, int j) {return this.tilesVisited[i][j];}

    public void setPlayerHealth(int health){
        this.playerHealth = health;
    }

    public void setPlayerStrength(int strength){
        this.playerStrength = strength;
    }

    public void setPlayerDefense(int defense){
        this.playerDefense = defense;
    }

    //make it so energy cannot go above 100 or below 0
    public void setEnergy(int energy){

        if (energy > 100){
            this.energy = 100;
        }
        else if (energy < 0){
            this.energy = 0;
        }
        else{

        this.energy = energy;
        }
    }

    public void setBeltNum(int beltNum){
        this.beltNum = beltNum;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public void setScore(int score){
        this.score = score;
    }

    //changes boolean value of tile to be true so we can know that this tile has been visited
    public void addTile(int i, int j) {this.tilesVisited[i][j] = true;}
}

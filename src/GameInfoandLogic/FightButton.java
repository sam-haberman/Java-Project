package GameInfoandLogic;

import Characters.*;
import GameInfoandLogic.CombatPanel;
import GameInfoandLogic.GameBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


//This class holds the FightButton in the Compat Panel. When this button is clicked the player and enemy both initiate an
//attack against each other where there strength and defense are compared and based on those numbers they each recieve
//some damage. The class checks after each instance of damage whether the player or the enemy has died and updates the game
//based on either death. (If player dies game ends and score is recorded) (If enemy dies, player gets experience and score bonus
//and goes back to the playing board)

//every construction is the same except for which enemy it takes in its construction
public class FightButton extends JButton implements ActionListener {
    //Instantiate classes for everything that will be passed into the constructors
    Player myChar;
    GameBoard gameBoard;
    EasyEnemy eEnemy;
    MediumEnemy mEnemy;
    HardEnemy hEnemy;
    FinalBoss boss;
    CombatPanel panel;
    JButton button;

    //constructor for easy Enemy
    public FightButton(Player p, GameBoard g, EasyEnemy e, CombatPanel pa, JButton b) {
        super("Make an attack!");
        myChar = p;
        gameBoard = g;
        eEnemy = e;
        panel = pa;
        button = b;
        this.addActionListener(this);
    }
    //constructor for medium enemy
    public FightButton(Player p, GameBoard g, MediumEnemy m, CombatPanel pa, JButton b) {
        super("Make an attack!");
        myChar = p;
        gameBoard = g;
        mEnemy = m;
        panel = pa;
        button = b;
        //adds actionListener that is the same throughout this class but for the Medium enemy class
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //find out damage for each attack, set to 0 if this would be negative
                int playerDamage = myChar.getPlayerStrength() - mEnemy.getDefense();
                int enemyDamage = mEnemy.getStrength() - myChar.getPlayerDefense();
                if (playerDamage < 0) {
                    playerDamage = 0;
                }
                if (enemyDamage < 0) {
                    enemyDamage = 0;
                }
                //updates enemy health and enemy panel health
                mEnemy.setHealth(mEnemy.getHealth() - playerDamage);
                panel.enemyHealth.setText("Health: " + mEnemy.getHealth());

                //updates players health and both gameboard panel and combatpanel health
                myChar.setPlayerHealth(myChar.getPlayerHealth() - enemyDamage);
                gameBoard.playerHealth.setText("Health: " + myChar.getPlayerHealth());
                panel.playerHealth.setText("Health: " + myChar.getPlayerHealth());

                //writes to combat panel textarea the results of the combat
                panel.combat.append("You have dealt " + playerDamage + " damage\n");
                panel.combat.append("You have taken " + enemyDamage + " damage\n\n");

                //checks to see if enemy or player has died after each incidence of combat
                if (myChar.getPlayerHealth() <= 0) {
                    panel.dispose();
                    gameBoard.checkHealth();
                }

                if (mEnemy.getHealth() <= 0) {
                    //if enemy is dead we give our player the respective experience and score bonus
                    //as well as updating them on the main panel
                    myChar.setExperience(myChar.getExperience() + mEnemy.getExperience());
                    gameBoard.playerExp.setText("Experience: " + myChar.getExperience());
                    myChar.setScore(myChar.getScore() + mEnemy.getScore());
                    gameBoard.playerScore.setText("Score: " + myChar.getScore());
                    //tells our user that the fight ended and they got certain bonuses as well as writing them to the
                    //gameboard chat
                    JOptionPane.showMessageDialog(null, "You have won this fight!");
                    JOptionPane.showMessageDialog(null, "You have gained " + mEnemy.getExperience() + " experience");
                    gameBoard.playerChat.append("\nYour score has increased by " + mEnemy.getScore());
                    gameBoard.playerChat.append("\nYour experience has increased by " + mEnemy.getExperience() + "\n");
                    //closes the combat panel and checks if the player is dead or not as well as naming the defeated enemys
                    //tile to grass so he is vanquished on the board and the panel is now a grass panel
                    //then we update the board and reset the health of the other enemys on the board to full for fresh
                    //new combat
                    panel.dispose();
                    gameBoard.checkHealth();
                    button.setName("Tiles.Grass");
                    gameBoard.updateBoard();
                    mEnemy.setRun(true);
                    mEnemy.resetHealth();
                    //check to see if player has enough experience to level up
                    if (myChar.getExperience() >= 100) {
                        gameBoard.levelUp();
                    }
                }

            }
        });
    }
    //constructor for Hard Enemy
    public FightButton(Player p, GameBoard g, HardEnemy h, CombatPanel pa, JButton b) {
        super("Make an attack!");
        myChar = p;
        gameBoard = g;
        hEnemy = h;
        panel = pa;
        button = b;
        //adds actionListener for hard Enemy
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //find out damage for each attack, set to 0 if this would be negative
                int playerDamage = myChar.getPlayerStrength() - hEnemy.getDefense();
                int enemyDamage = hEnemy.getStrength() - myChar.getPlayerDefense();
                if (playerDamage < 0) {
                    playerDamage = 0;
                }
                if (enemyDamage < 0) {
                    enemyDamage = 0;
                }
                hEnemy.setHealth(hEnemy.getHealth() - playerDamage);
                panel.enemyHealth.setText("Health: " + hEnemy.getHealth());

                myChar.setPlayerHealth(myChar.getPlayerHealth() - enemyDamage);
                gameBoard.playerHealth.setText("Health: " + myChar.getPlayerHealth());
                panel.playerHealth.setText("Health: " + myChar.getPlayerHealth());

                panel.combat.append("You have dealt " + playerDamage + " damage\n");
                panel.combat.append("You have taken " + enemyDamage + " damage\n\n");

                //checks to see if enemy or player has died after each incidence of combat
                if (myChar.getPlayerHealth() <= 0) {
                    panel.dispose();
                    gameBoard.checkHealth();
                }

                if (hEnemy.getHealth() <= 0) {

                    myChar.setExperience(myChar.getExperience() + hEnemy.getExperience());
                    gameBoard.playerExp.setText("Experience: " + myChar.getExperience());
                    myChar.setScore(myChar.getScore() + hEnemy.getScore());
                    gameBoard.playerScore.setText("Score: " + myChar.getScore());
                    //update score on main panel
                    gameBoard.playerChat.append("\nYour score has increased by " + hEnemy.getScore());
                    gameBoard.playerChat.append("\nYour experience has increased by " + hEnemy.getExperience() + "\n");
                    JOptionPane.showMessageDialog(null, "You have won this fight!");
                    JOptionPane.showMessageDialog(null, "You have gained " + hEnemy.getExperience() + " experience");
                    panel.dispose();
                    gameBoard.checkHealth();
                    button.setName("Tiles.Grass");
                    gameBoard.updateBoard();
                    hEnemy.setRun(true);
                    hEnemy.resetHealth();
                    //check to see if player has enough experience to level up
                    if (myChar.getExperience() >= 100) {
                        gameBoard.levelUp();
                    }
                }

            }
        });
    }

    //Action Listener used for the Easy Enemy constructor, all the Action Listeners are the same except for which enemy
    //is being fought against (except for the final boss where you win the game when you defeat it)
    //Comments explaining each step in depth are added for the Medium Enemy constructor and they are the same for each
    //constructor

    //action that happens when player decides to make an attack against the enemy
    public void actionPerformed(ActionEvent e) {
        //find out damage for each attack, set to 0 if this would be negative
        int playerDamage = myChar.getPlayerStrength() - eEnemy.getDefense();
        int enemyDamage = eEnemy.getStrength() - myChar.getPlayerDefense();
        if (playerDamage < 0){
           playerDamage = 0;
        }
        if (enemyDamage < 0){
           enemyDamage = 0;
        }
        eEnemy.setHealth(eEnemy.getHealth() - playerDamage);
        panel.enemyHealth.setText("Health: " + eEnemy.getHealth());

        myChar.setPlayerHealth(myChar.getPlayerHealth() - enemyDamage);
        gameBoard.playerHealth.setText("Health: " + myChar.getPlayerHealth());
        panel.playerHealth.setText("Health: " + myChar.getPlayerHealth());

        panel.combat.append("You have dealt "+ playerDamage + " damage\n");
        panel.combat.append("You have taken "+ enemyDamage+ " damage\n\n");

        //checks to see if enemy or player has died after each incidence of combat
        if (myChar.getPlayerHealth() <= 0){
            panel.dispose();
            gameBoard.checkHealth();
        }

        if (eEnemy.getHealth() <= 0){

            myChar.setExperience(myChar.getExperience() + eEnemy.getExperience());
            gameBoard.playerExp.setText("Experience: "+ myChar.getExperience());
            myChar.setScore(myChar.getScore() + eEnemy.getScore());
            gameBoard.playerScore.setText("Score: "+ myChar.getScore());
            //update score on main panel
            gameBoard.playerChat.append("\nYour score has increased by "+ eEnemy.getScore());
            gameBoard.playerChat.append("\nYour experience has increased by "+ eEnemy.getExperience()+ "\n");
            JOptionPane.showMessageDialog(null, "You have won this fight!");
            JOptionPane.showMessageDialog(null, "You have gained " + eEnemy.getExperience() + " experience");
            panel.dispose();
            gameBoard.checkHealth();
            button.setName("Tiles.Grass");
            gameBoard.updateBoard();
            eEnemy.setRun(true);
            eEnemy.resetHealth();
            //check to see if player has enough experience to level up
            if (myChar.getExperience() >= 100){
                gameBoard.levelUp();
            }
        }

    }

    //constructor for Final Boss fight button
    public FightButton(Player p, GameBoard g, FinalBoss bo, CombatPanel pa, JButton b){
        super("Make an attack!");
        myChar = p;
        gameBoard = g;
        boss = bo;
        panel = pa;
        button = b;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //find out damage for each attack, set to 0 if this would be negative
                int playerDamage = myChar.getPlayerStrength() - boss.getDefense();
                int enemyDamage = boss.getStrength() - myChar.getPlayerDefense();
                if (playerDamage < 0){
                    playerDamage = 0;
                }
                if (enemyDamage < 0){
                    enemyDamage = 0;
                }
                boss.setHealth(boss.getHealth() - playerDamage);
                panel.enemyHealth.setText("Health: " + boss.getHealth());

                myChar.setPlayerHealth(myChar.getPlayerHealth() - enemyDamage);
                gameBoard.playerHealth.setText("Health: " + myChar.getPlayerHealth());
                panel.playerHealth.setText("Health: " + myChar.getPlayerHealth());

                panel.combat.append("You have dealt "+ playerDamage + " damage\n");
                panel.combat.append("You have taken "+ enemyDamage+ " damage\n\n");

                //checks to see if enemy or player has died after each incidence of combat
                if (myChar.getPlayerHealth() <= 0){
                    panel.dispose();
                    gameBoard.checkHealth();
                }

                if (boss.getHealth() <= 0) {

                    //You win the game and your score is saved and checked to see if  a new high score
                    myChar.setScore(myChar.getScore() + boss.getScore());
                    JOptionPane.showMessageDialog(null, "You have won the game!");
                    JOptionPane.showMessageDialog(null, "Your final score is " + myChar.getScore());
                    panel.dispose();
                    try {
                        BufferedWriter output = new BufferedWriter(new FileWriter("Scores.txt", true));
                        output.newLine();
                        output.append(myChar.getName() + " " + myChar.getScore());
                        output.close();
                    } catch(IOException ex1){
                        JOptionPane.showMessageDialog(null, "Your score was unable to be added due to an error.");
                    }
                    gameBoard.dispose();
                }
            }
        });
    }
}

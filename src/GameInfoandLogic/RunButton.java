package GameInfoandLogic;

import Characters.*;
import GameInfoandLogic.CombatPanel;
import GameInfoandLogic.GameBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class is for the Run button that the player can click in the combat panel that lets the player run away from combat at any
//point. If the player runs the enemies health is reset back to full and the player loses 20 energy as a penalty for running
//If the player runs his position doesnt change on the gameboard
//every constructor is the same except for which enemy is participating in the combat panel
public class RunButton extends JButton implements ActionListener {
    //variables that are used in the constructor for each run button
    Player myChar;
    GameBoard gameBoard;
    EasyEnemy eEnemy;
    MediumEnemy mEnemy;
    HardEnemy hEnemy;
    FinalBoss boss;
    CombatPanel panel;

    //constructor for run button for easy enemy
    public RunButton(Player p, GameBoard g, EasyEnemy e, CombatPanel pa){
        super("Run away!");
        myChar = p;
        gameBoard = g;
        eEnemy = e;
        panel = pa;
        this.addActionListener(this);
    }
    //constructor for run button for medium enemy
    public RunButton(Player p, GameBoard g, MediumEnemy m, CombatPanel pa){
        super("Run away!");
        myChar = p;
        gameBoard = g;
        mEnemy = m;
        panel = pa;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mEnemy.resetHealth();
                myChar.setEnergy(myChar.getEnergy()-20);
                gameBoard.playerEnergy.setText("Energy: " + myChar.getEnergy());
                mEnemy.setRun(true);
                gameBoard.playerChat.append("\nYou have ran away.\nYour energy has been reduced by 20\n");
                //close combat panel
                panel.dispose();
                gameBoard.checkEnergy();
                gameBoard.checkHealth();
            }
            });}
    //constructor for run button for hard enemy
    public RunButton(Player p, GameBoard g, HardEnemy h, CombatPanel pa){
        super("Run away!");
        myChar = p;
        gameBoard = g;
        hEnemy = h;
        panel = pa;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hEnemy.resetHealth();
                myChar.setEnergy(myChar.getEnergy()-20);
                gameBoard.playerEnergy.setText("Energy: " + myChar.getEnergy());
                hEnemy.setRun(true);
                gameBoard.playerChat.append("\nYou have ran away.\nYour energy has been reduced by 20\n");
                //close combat panel
                panel.dispose();
                gameBoard.checkEnergy();
                gameBoard.checkHealth();
            }
        });
    }

    //action that happens when player decides to run away and not fight
    //resets enemies health, and player character is penalized by losing 20 energy
    public void actionPerformed(ActionEvent e) {
        eEnemy.resetHealth();
        myChar.setEnergy(myChar.getEnergy()-20);
        gameBoard.playerEnergy.setText("Energy: " + myChar.getEnergy());
        eEnemy.setRun(true);
        gameBoard.playerChat.append("\nYou have ran away.\nYour energy has been reduced by 20\n");
        //close combat panel
        panel.dispose();
        gameBoard.checkEnergy();
        gameBoard.checkHealth();
    }
    //constructor for run button for final boss
    public RunButton(Player p, GameBoard g, FinalBoss b, CombatPanel pa){
        super("Run away!");
        myChar = p;
        gameBoard = g;
        boss = b;
        panel = pa;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.resetHealth();
                myChar.setEnergy(myChar.getEnergy()-20);
                gameBoard.playerEnergy.setText("Energy: " + myChar.getEnergy());
                boss.setRun(true);
                gameBoard.playerChat.append("\nYou have ran away.\nYour energy has been reduced by 20\n");
                //close combat panel
                panel.dispose();
                gameBoard.checkEnergy();
                gameBoard.checkHealth();
            }
        });}
}

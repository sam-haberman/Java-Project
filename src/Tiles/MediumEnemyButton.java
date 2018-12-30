package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;
//This class is the button that holds the Medium Enemy
public class MediumEnemyButton extends JButton implements ActionListener {
    //these variables are all used in the constructors of the button
    ImageIcon medium;
    Player myChar;
    GameBoard gameBoard;
    MediumEnemy mediumEnemy;

    public MediumEnemyButton(Player p, GameBoard g, MediumEnemy m ){
        mediumEnemy = m;
        myChar = p;
        gameBoard = g;
        medium = new ImageIcon(this.getClass().getResource("/Images/mediumenemy.jpg"));
        this.setIcon(medium);
        this.addActionListener(this);
    }

    //action Listener that checks to see if tile is a valid move and if so will open combat against the enemy and then update
    //the board based on what you do
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        for (int i = 0; i < gameBoard.squares.length; i++) {
            for (int j = 0; j < gameBoard.squares[i].length; j++) {
                if (source == gameBoard.squares[i][j]) {
                    gameBoard.processClick(i, j);
                    gameBoard.updateBoard();
                    return;
                }
            }
        }
    }
}

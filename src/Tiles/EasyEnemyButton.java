package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//This class is the JButton that represents our Easy Enemy and holds the enemy as part of its constructor
public class EasyEnemyButton extends JButton implements ActionListener {
    //Instantiate classes for everything that will be passed into the constructors
    ImageIcon easy;
    Player myChar;
    GameBoard gameBoard;
    EasyEnemy easyEnemy;

    public EasyEnemyButton(Player p, GameBoard g, EasyEnemy e ){
        easyEnemy = e;
        myChar = p;
        gameBoard = g;
        easy = new ImageIcon(this.getClass().getResource("/Images/easyenemy.jpg"));
        this.setIcon(easy);
        this.addActionListener(this);
    }


    //Action Listener that checks each click on the Easy Enemy Button to see if it is a valid move (within 1 space from player)
    //If it is a valid move then the click is processed (evaluated depending on what class the button is) and the board is
    //updated to reflect what happens.
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

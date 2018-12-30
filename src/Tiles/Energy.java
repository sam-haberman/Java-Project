package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//This class is for the energy tile JButton, this tile adds restores the players energy by 5 but making sure the player
//cannot exceed 100 energy.
public class Energy extends JButton implements ActionListener {
    //Instantiate classes for everything that will be passed into the constructors
    ImageIcon energy;
    Player myChar;
    GameBoard gameBoard;

    public Energy(Player p, GameBoard g) {
        myChar = p;
        gameBoard = g;
        energy = new ImageIcon(this.getClass().getResource("/Images/energy.png"));
        this.setIcon(energy);
        this.addActionListener(this);
    }
    //Action Listener that checks to see if the click is a valid move and if so processes it and does a method depending on
    //what class the button is and then updates the board to reflect these changes
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
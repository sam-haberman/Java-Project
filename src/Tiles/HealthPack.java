package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//Tile that holds our healthpack our player can pick up to restore health, but not go above 100 health
public class HealthPack extends JButton implements ActionListener {

    //variables used in our constructor
    ImageIcon healthpack;
    Player myChar;
    GameBoard gameBoard;

    //creates instance of healthpack
    public HealthPack(Player p, GameBoard g) {

        myChar = p;
        gameBoard = g;
        healthpack = new ImageIcon(this.getClass().getResource("/Images/healthpack.png"));
        this.setIcon(healthpack);
        this.addActionListener(this);
    }
    //Action Listener that checks if tile is valid to be clicked on, and if so will run the Healthpack method and update
    //the board
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

package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//This class is the Tiles.Lion Tile, when you interact with this tile the lion "attacks" you and you lose 1 defense
public class Lion extends JButton implements ActionListener {
    //variables used in the constructor of the button
    ImageIcon lion;
    Player myChar;
    GameBoard gameBoard;


    public Lion(Player p, GameBoard g) {

        myChar = p;
        gameBoard = g;
        lion = new ImageIcon(this.getClass().getResource("/Images/lion.jpg"));
        this.setIcon(lion);
        this.addActionListener(this);
    }
    //Action Listener that checks if tile is valid for a move, if so will end up running the method that has our player
    //interact with the lion and update the board
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

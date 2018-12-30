package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//This class is the quicksand tile that hurts the player when you interact with it
public class Quicksand extends JButton implements ActionListener {
    //variables used in creation of quicksand button
    ImageIcon quicksand;
    Player myChar;
    GameBoard gameBoard;


    public Quicksand(Player p, GameBoard g) {
        myChar = p;
        gameBoard = g;
        quicksand = new ImageIcon(this.getClass().getResource("/Images/quicksand.jpg"));
        this.setIcon(quicksand);
        this.addActionListener(this);
    }
    //Action Listener that will go off when tile is clicked. if tile is valid this will result in the player losing health
    //from falling in the quicksand and then the board will update
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

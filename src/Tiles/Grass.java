package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//empty tile, fills up space on board but still costs energy to traverse
public class Grass extends JButton implements ActionListener {
    //variables instantaited for use in the constructor
    ImageIcon grass;
    Player myChar;
    GameBoard gameBoard;


    public Grass(Player p, GameBoard g) {
        myChar = p;
        gameBoard = g;
        grass = new ImageIcon(this.getClass().getResource("/Images/grass.png"));
        this.setIcon(grass);
        this.addActionListener(this);
    }
    //Action Listener that checks to see if the tile was within players range and will move the player to this tile
    //only costs an energy if the player hasnt visited the tile before
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

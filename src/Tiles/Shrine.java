package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//This class implements the Tiles.Shrine tile that lets you choose to increase your strength by 1 or your defense by 1
public class Shrine extends JButton implements ActionListener {
    //creates variables for constructor of tile as well as imageicon variable to set the picture for our tile
    public ImageIcon shrine;
    Player myChar;
    GameBoard gameBoard;


    public Shrine(Player p, GameBoard g) {
        myChar = p;
        gameBoard = g;
        shrine = new ImageIcon(this.getClass().getResource("/Images/shrine.jpg"));
        this.setIcon(shrine);
        this.addActionListener(this);
    }
    //Action Listener that checks if the tile is a valid move (within 1 space of player) if so it will process this click and
    //run the Tiles.Shrine method and then update the board
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

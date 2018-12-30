package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//This class is the button that holds the hard enemy
public class HardEnemyButton extends JButton implements ActionListener {
    //variables used in the constructor of our button
    ImageIcon hard;
    Player myChar;
    GameBoard gameBoard;
    HardEnemy hardEnemy;

    public HardEnemyButton(Player p, GameBoard g, HardEnemy h){
        hardEnemy = h;
        myChar = p;
        gameBoard = g;
        hard = new ImageIcon(this.getClass().getResource("/Images/hardenemy.jpg"));
        this.setIcon(hard);
        this.addActionListener(this);
    }
    //Action Listener that checks to see if the tile is a valid move and evaluates the game and board based on the results
    //of the combat with our Hard Enemy
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

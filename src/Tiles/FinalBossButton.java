package Tiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Characters.*;
import GameInfoandLogic.*;

//This class is the first enemy and is the easiest (weakest) to defeat
public class FinalBossButton extends JButton implements ActionListener {
    //instantiate variables used in the constructor of this button
    ImageIcon bossPic;
    Player myChar;
    GameBoard gameBoard;
    FinalBoss boss;

    FinalBossButton(Player p, GameBoard g, FinalBoss b){
        boss = b;
        myChar = p;
        gameBoard = g;
        bossPic = new ImageIcon(this.getClass().getResource("/Images/hardenemy.jpg"));
        this.setIcon(bossPic);
        this.addActionListener(this);
    }

    //Action Listener that checks that the move is within 1 square of the player and if so opens combat against the boss and
    //updates board based on results (game end/ or running)
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

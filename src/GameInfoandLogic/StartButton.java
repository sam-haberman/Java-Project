package GameInfoandLogic;

import GameInfoandLogic.ChooseName;
import GameInfoandLogic.ChoosePortrait;
import GameInfoandLogic.GameBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Creating Start Button for Start window of game.
public class StartButton extends JButton implements ActionListener {
    //StartButton takes name from assignment variable in StartWindow and adds an action listener for when button is
    //clicked
    public StartButton(String c){
        super(c);
        this.addActionListener(this);
    }
    //ActionEvent that opens new panel that starts the game.
    //First Asks user for the Characters Name, then Asks the User to choose a character portrait
    //Finally brings up the game board to be played on
    public void actionPerformed(ActionEvent e){
        //Create JOption Pane that asks for user to enter a character name
        ChooseName chName = new ChooseName();
        //Create JOption Pane that asks you to pick a character portrait
        ChoosePortrait charPortrait = new ChoosePortrait();
        //Open up Game Board
        GameBoard gameBoard = new GameBoard();
    }
}

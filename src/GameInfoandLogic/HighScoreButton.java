package GameInfoandLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Creating High Score Button for Start window of game.
public class HighScoreButton extends JButton implements ActionListener {
    //HighScoreButton takes name from assignment variable in StartWindow and adds an action listener for when button is
    //clicked
    public HighScoreButton(String c){
        super(c);
        this.addActionListener(this);
    }
    //ActionEvent that opens up a new window displaying all the previous high scores for the game
    public void actionPerformed(ActionEvent e){
        //Opens ScoreBoard panel to display high scores
        ScoreBoard scoreBoard = new ScoreBoard();
    }
}

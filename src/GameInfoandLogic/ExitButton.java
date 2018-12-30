package GameInfoandLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Creating Exit Button for Start window of game.
public class ExitButton extends JButton implements ActionListener {
    //ExitButton takes name from assignment variable inStartWindow and adds an action listener for when button is
    //clicked
    public ExitButton(String c){
        super(c);
        this.addActionListener(this);
    }
    //ActionEvent that closes program when button is clicked
    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }
}

package GameInfoandLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//create a ComboBox that has a dropdown menu of our difficulty settings stored in the String array diff
public class DifficultySetting extends JComboBox{

    //create difficulty variable that can be assigned here but used to assess game difficulty when game starts
    public static String difficulty;

    public DifficultySetting(String[] diff){

        super(diff);
        //sets base difficulty to Easy, this is so program runs on easy the default setting if it is not changed
        difficulty = "Easy";
        this.addActionListener(this);
    }

    //assigns difficulty selected in dropbox to the difficulty variable
    public void actionPerformed(ActionEvent e){
        difficulty = this.getSelectedItem().toString();
    }
}

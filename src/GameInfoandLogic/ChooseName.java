package GameInfoandLogic;

import javax.swing.*;

//JOptionPane that asks the User for their character name and assigns it to the player class upon game start
public class ChooseName extends JOptionPane {
    //creates global variable for characterName
    public static String charName;
    // variable that checks whether the user has entered a name (anything that is not blank)
    private boolean correctName = false;


    //class checks whether the user has a name which starts as false. Then the user is asked what is their characters name
    //if they enter nothing then they recieve an error message until they enter a real value for their name.
    //Then the name is saved for further use
    public ChooseName() {
        while (correctName == false) {
            try {
                charName = JOptionPane.showInputDialog(null, "What is your characters name?",
                        "Choose Your Characters Name", JOptionPane.QUESTION_MESSAGE);
                if (charName == null || charName.equals(""))
                    throw new IllegalArgumentException();

                else{
                    correctName = true;
                }
            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(null, "Please enter a name");
            }
        }
    }
}

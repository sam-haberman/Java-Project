package GameInfoandLogic;

import javax.swing.*;
import java.awt.*;
//Creates JOptionPane class that lets our user select their avatar from a given set and records the selection
//also holds images for belts and the creation of the belt picture ImageIcon array
public class ChoosePortrait extends JOptionPane {
    //sets our avatars as ImageIcons
    ImageIcon chuckNorris;
    ImageIcon bruceLee;
    ImageIcon jackieChan;
    ImageIcon bartBaesens;
    ImageIcon bender;
    ImageIcon rockem;
    // Int that keeps track of what photo we are using in our pics array
    public static int avatarNum;
    //Created Image array that keeps track of who our player chose to have their avatar as
    public static ImageIcon[] pics = new ImageIcon[6];

    //makes sure we are choosing a real picture, and not closing the window
    private boolean correctPicture = false;

    public ChoosePortrait(){
        while (correctPicture == false){
        //adding Images to array as well as resizing them so they fit our JOptionPane
        chuckNorris = new ImageIcon(this.getClass().getResource("/Images/chuck-norris.jpg"));
        Image chuckN = chuckNorris.getImage();
        Image newChuckN = chuckN.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        pics[0] = new ImageIcon(newChuckN);

        bruceLee = new ImageIcon(this.getClass().getResource("/Images/bruce-lee.jpg"));
        Image bruceL = bruceLee.getImage();
        Image newbruceL = bruceL.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        pics[1] = new ImageIcon(newbruceL);

        jackieChan = new ImageIcon(this.getClass().getResource("/Images/Jackie-chan.jpg"));
        Image jackieC = jackieChan.getImage();
        Image newjackieC = jackieC.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        pics[2] = new ImageIcon(newjackieC);

        bartBaesens = new ImageIcon(this.getClass().getResource("/Images/bart-baesens.jpg"));
        Image bartB = bartBaesens.getImage();
        Image newbartB = bartB.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        pics[3] = new ImageIcon(newbartB);

        bender = new ImageIcon(this.getClass().getResource("/Images/bender.png"));
        Image benderI = bender.getImage();
        Image newBender = benderI.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        pics[4] = new ImageIcon(newBender);

        rockem = new ImageIcon(this.getClass().getResource("/Images/rockemsockem.jpg"));
        Image rockemS = rockem.getImage();
        Image newRockEm = rockemS.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        pics[5] = new ImageIcon(newRockEm);

        ImageIcon[] humans = new ImageIcon[4];
        System.arraycopy(pics,0,humans,0,4);
        ImageIcon[] robots = new ImageIcon[2];
        System.arraycopy(pics,4,robots,0,2);
        //Depending on the first digit of your characters name you get a different set of avatars to choose from
        try{
        if(ChooseName.charName.substring(0,1).equals("0")){
            avatarNum = JOptionPane.showOptionDialog(null, "What would you like your character to look like?",
                    "Choose Your Characters Portrait", 0,
                    JOptionPane.QUESTION_MESSAGE, null, robots, 0) + 4;
        }

        else {
            //pane that pops up and lets user select avatar for the game
            avatarNum = JOptionPane.showOptionDialog(null, "What would you like your character to look like?",
                    "Choose Your Characters Portrait", 0,
                    JOptionPane.QUESTION_MESSAGE, null, humans, 0);
        }

        if (avatarNum == -1){
            throw new IllegalArgumentException();
        }
        else{
            correctPicture = true;
        }
    } catch (IllegalArgumentException e){

            JOptionPane.showMessageDialog(null, "Please choose an avatar");
        }
}}}

package GameInfoandLogic;

import javax.swing.*;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

//Creates the Start Window for the game, this window lets you choose your difficulty setting with a combo box, lets you
//Exit the Start window, or start a game or open the high scores. You also use a slider to choose your starting
//Strength and Defense attributes
public class StartWindow extends JFrame{
    //panel for StartWindow
    JPanel panel = new JPanel();
    //panel for holding Start and Exit Buttons on Bottom of Screen
    JPanel startPanel = new JPanel();
    //Adding Exit Button
    ExitButton exitB = new ExitButton("Exit");
    //Adds Start Game Button
    StartButton startB = new StartButton("Start Game!");
    //Adds High Score Button
    HighScoreButton highScoreB = new HighScoreButton("High Scores!");
    //Adds Difficulty Dropdown Window using diff array with difficulty options
    String[] diff = {"Easy", "Medium", "Hard"};
    DifficultySetting diffSetting = new DifficultySetting(diff);
    //Create TextField Label to explain ComboBox
    JLabel diffQuestion = new JLabel("Please choose your difficulty setting:");
    //Create new panel to hold difficulty comboBox and Label explaining it
    JPanel diffPanel = new JPanel();
    //Create new panel to hold attribute slider and related information
    JPanel attPanel = new JPanel();
    //Creates Attribute Slider and defines min and max values as well as initial placement
    JSlider attSlider = new JSlider(0,10, 0);
    //Creates JLabel explaining attribute slider
    JLabel attExplain = new JLabel("Please choose your starting Strength value: Str + Def = 10");
    //Initialise Strength value for Player Class, we take this value from the att slider
    public static int strength;

    public static void main(String[] args){
        new StartWindow();
    }
    // Creating the window that starts when loading the game. This window should have a button to display high scores,
    // a button to start the game, a difficulty setting (from dropdown window), a exit button, and a slider that
    // allows you to choose your balance of strength vs defense.
    public StartWindow(){
        super("Karate Showdown!");
        setSize(400,200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        //adds start, exit and high scores button to game panel on bottom of border layout
        startPanel.add(startB);
        startPanel.add(exitB);
        startPanel.add(highScoreB);
        //combines difficulty ComboBox and label into difficulty panel
        diffPanel.add(diffQuestion);
        diffPanel.add(diffSetting);

        //Sets up attribute slider so that ticks are labeled and that we can read the Players starting strength value
        // from the slider upon game start
        attSlider.setMajorTickSpacing(1);
        attSlider.setPaintTicks(true);
        attSlider.setLabelTable(attSlider.createStandardLabels(1));
        attSlider.setPaintLabels(true);
        attSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                strength = attSlider.getValue();
            }
        });

        //Adds attribute slider to attribute panel and makes the attribute panel a grid layout
        attPanel.setLayout(new GridLayout(2,0));
        attPanel.add(attExplain);
        attPanel.add(attSlider);
        //adds panels to StartWindow panel
        panel.add(startPanel, BorderLayout.SOUTH);
        panel.add(diffPanel, BorderLayout.CENTER);
        panel.add(attPanel, BorderLayout.NORTH);
        add(panel);
        setVisible(true);
    }
}

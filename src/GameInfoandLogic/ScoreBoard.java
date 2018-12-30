package GameInfoandLogic;

import GameInfoandLogic.GameScore;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;


//This class is the ScoreBoard that will keep track and display the top 10 high scores
public class ScoreBoard extends JFrame {
    //creates highscores array that keeps track of top 10 high scores along with the player name
    ArrayList<GameScore> highScores = new ArrayList<>();
    //Create List to hold all readings from scores text file
    ArrayList<String> scoresReading = new ArrayList<>();
    //Create JFrames that show title and top 10 scores that are updated with the updateHighScores method
    JPanel scores = new JPanel();
    JLabel scoresTitle = new JLabel("Top 5 High Scores!");
    JLabel scoreNumberOne = new JLabel();
    JLabel scoreNumberTwo = new JLabel();
    JLabel scoreNumberThree = new JLabel();
    JLabel scoreNumberFour = new JLabel();
    JLabel scoreNumberFive= new JLabel();

    //this variable is the reader we use to read our text file where the scores are held
    BufferedReader reader;

    //creation of our scoreboard, sets size and layout and adds our labels
    public ScoreBoard(){

        super("High Scores!");
        setSize(300,300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        scores.setLayout(new GridLayout(6,1));
        scores.add(scoresTitle);
        RetrieveScores();
        SplitScores();
        updateHighScores();
        scores.add(scoreNumberOne);
        scores.add(scoreNumberTwo);
        scores.add(scoreNumberThree);
        scores.add(scoreNumberFour);
        scores.add(scoreNumberFive);
        setVisible(true);
        add(scores);
    }


    //method that updates the highscores with the new most recent top 10 scores after sorting the list by highest scores
    public void updateHighScores(){


        //sort highscores based on highest score descending
        Collections.sort(highScores, Comparator.comparingInt(GameScore::getScore).reversed());
        //sets the sorted high scores to our labels
        try {
            scoreNumberOne.setText("1: "+ highScores.get(0).getName() + "-" + highScores.get(0).getScore());
            scoreNumberTwo.setText("2: "+ highScores.get(1).getName() + "-" + highScores.get(1).getScore());
            scoreNumberThree.setText("3: "+ highScores.get(2).getName() + "-" + highScores.get(2).getScore());
            scoreNumberFour.setText("4: "+ highScores.get(3).getName() + "-" + highScores.get(3).getScore());
            scoreNumberFive.setText("5: "+ highScores.get(4).getName() + "-" + highScores.get(4).getScore());
        } catch(IndexOutOfBoundsException e){

            JOptionPane.showMessageDialog(null, "We need more scores to display");
        }
    }

    // method that reads each line from the Scores file and saves it to a list
    public void RetrieveScores(){
        try {
            reader = new BufferedReader(new FileReader("Scores.txt"));
            reader.readLine();
            String line = reader.readLine();

            while (line != null){
               scoresReading.add(line);
               line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){}
    }

    //method that takes our list of Strings and splits them into the Name Score list
    public void SplitScores(){
        for (String i : scoresReading){
            String[] seperatedScores = i.split(" ");
            String x = seperatedScores[0];
            int y = Integer.parseInt(seperatedScores[1]);
            highScores.add(new GameScore(x,y));
        }
    }
}

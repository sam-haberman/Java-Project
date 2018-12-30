package GameInfoandLogic;

import Characters.*;
import Tiles.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//This class is the GameBoard that will load after the user selects their name and avatar portrait
//Holds the player information as well as the tiles of the game
public class GameBoard extends JFrame{

    //Create user player class based on variables picked during start process
    Player myChar = new Player(ChooseName.charName, ChoosePortrait.pics[ChoosePortrait.avatarNum], StartWindow.strength);

    //keeps track of dificulty setting and changes attributes of enemies based on difficulty chosen
    String difficultyLevel = DifficultySetting.difficulty;
    //creating three variations of Enemys as well as our Final Boss
    EasyEnemy eEnemy = new EasyEnemy(difficultyLevel);
    MediumEnemy mEnemy = new MediumEnemy(difficultyLevel);
    HardEnemy hEnemy = new HardEnemy(difficultyLevel);
    FinalBoss finalBoss = new FinalBoss(difficultyLevel);

    //Creates panel for side of gameboard displaying player information
    JPanel playerInfo = new JPanel();
    //Creates panel for actual part of gameboard
    JPanel gameBoard = new JPanel();
    //Creates overall panel for game
    JPanel game = new JPanel();

    //Create JLabels that hold information to be displayed on GameBoard
    //JLabel that holds avatar picture
    JLabel avatarPic = new JLabel(myChar.getAvatar());
    //JLabel that holds players name
    JLabel playerName = new JLabel(myChar.getName());
    //Label that displays users Health
    JLabel playerHealth = new JLabel("Health: " + myChar.getPlayerHealth());
    //Label that displays users Tiles.Energy
    JLabel playerEnergy = new JLabel("Tiles.Energy: " + myChar.getEnergy());
    //Label that displays players Experience
    JLabel playerExp = new JLabel("Experience: " + myChar.getExperience());
    //Label that displays players current Score
    JLabel playerScore = new JLabel("Score: "+ myChar.getScore());
    //Create Panel that holds attributes placed in playerinfo panel
    JPanel playerAtt = new JPanel();
    //Create TextArea where we can display text notifications or results from playing the game
    //Make Text Area large so we can display lots of information and make the panel look nice at the top
    JTextArea playerChat = new JTextArea(25, 22);
    //Create ScrollPane for our chat output and put the playerChat TextArea in the ScrollPane
    JScrollPane playerScroll = new JScrollPane(playerChat, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //Create JLabel that displays character belt level
    JLabel avatarBelt = new JLabel(myChar.updateBelt());




    //Creating the Gameboard
    public GameBoard() {
        super("The Karate Showdown!");
        //creating layout of our panels and board size
        setSize(1500, 800);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        gameBoard.setLayout(new GridLayout(10, 10));
        playerInfo.setLayout(new BorderLayout());
        game.setLayout(new BorderLayout());
        playerAtt.setLayout(new GridLayout(6, 1));

        //Add player attributes to player attribute panel
        playerAtt.add(playerName);
        playerAtt.add(avatarBelt);
        playerAtt.add(playerHealth);
        playerAtt.add(playerEnergy);
        playerAtt.add(playerExp);
        playerAtt.add(playerScore);
        //Add Avatar picture, attributes and chat window to Playerinfo panel
        playerInfo.add(avatarPic, BorderLayout.NORTH);
        playerInfo.add(playerAtt, BorderLayout.CENTER);
        playerInfo.add(playerScroll, BorderLayout.SOUTH);
        //block input from being written in our chat window
        playerChat.setEditable(false);
        //Add minipanels to major panel as well as adding the main panel to frame and setting it to be visible
        game.add(gameBoard, BorderLayout.CENTER);
        game.add(playerInfo, BorderLayout.EAST);
        add(game);
        setVisible(true);
        //write starting game information to player text chat
        playerChat.append("Good Luck!\n");
        playerChat.append("\nYour starting strength is " + myChar.getPlayerStrength());
        playerChat.append("\nYour starting defense is " + myChar.getPlayerDefense() + "\n");

        //update all images used on board to scale better
        karateka = new ImageIcon(this.getClass().getResource("/Images/karate.PNG"));
        Image karate = karateka.getImage();
        Image newKarate = karate.getScaledInstance(125,90, Image.SCALE_SMOOTH);
        karateka = new ImageIcon(newKarate);

        grass = new ImageIcon(this.getClass().getResource("/Images/grass.png"));
        Image grassUpdate = grass.getImage();
        Image newGrass = grassUpdate.getScaledInstance(125,90, Image.SCALE_SMOOTH);
        grass = new ImageIcon(newGrass);

        black = new ImageIcon(this.getClass().getResource("/Images/black.PNG"));

        shrine = new ImageIcon(this.getClass().getResource("/Images/shrine.jpg"));
        Image shrineUpdate = shrine.getImage();
        Image newShrine = shrineUpdate.getScaledInstance(125,90,Image.SCALE_SMOOTH);
        shrine = new ImageIcon(newShrine);

        energy = new ImageIcon(this.getClass().getResource("/Images/energy.png"));
        Image energyUpdate = energy.getImage();
        Image newEnergy = energyUpdate.getScaledInstance(125,90,Image.SCALE_SMOOTH);
        energy = new ImageIcon(newEnergy);

        healthpack = new ImageIcon(this.getClass().getResource("/Images/healthpack.png"));
        Image healthpackUpdate = healthpack.getImage();
        Image newHealthpack = healthpackUpdate.getScaledInstance(125,90,Image.SCALE_SMOOTH);
        healthpack = new ImageIcon(newHealthpack);

        quicksand = new ImageIcon(this.getClass().getResource("/Images/quicksand.jpg"));
        Image quicksandUpdate = quicksand.getImage();
        Image newQuicksand = quicksandUpdate.getScaledInstance(125,90, Image.SCALE_SMOOTH);
        quicksand = new ImageIcon(newQuicksand);

        easyEnemy = new ImageIcon(this.getClass().getResource("/Images/easyenemy.jpg"));
        Image easyEnemyUpdate = easyEnemy.getImage();
        Image newEasyEnemy = easyEnemyUpdate.getScaledInstance(125,90,Image.SCALE_SMOOTH);
        easyEnemy = new ImageIcon(newEasyEnemy);

        mediumEnemy = new ImageIcon(this.getClass().getResource("/Images/mediumenemy.jpg"));
        Image mediumEnemyUpdate = mediumEnemy.getImage();
        Image newMediumEnemy = mediumEnemyUpdate.getScaledInstance(125,90,Image.SCALE_SMOOTH);
        mediumEnemy = new ImageIcon(newMediumEnemy);

        hardEnemy = new ImageIcon(this.getClass().getResource("/Images/hardenemy.jpg"));
        Image hardEnemyUpdate = hardEnemy.getImage();
        Image newHardEnemy = hardEnemyUpdate.getScaledInstance(125,80,Image.SCALE_SMOOTH);
        hardEnemy = new ImageIcon(newHardEnemy);

        boss = new ImageIcon(this.getClass().getResource("/Images/finalboss.jpg"));
        Image bossUpdate = boss.getImage();
        Image newBoss = bossUpdate.getScaledInstance(125,80,Image.SCALE_SMOOTH);
        boss = new ImageIcon(newBoss);

        lion = new ImageIcon(this.getClass().getResource("/Images/lion.jpg"));
        Image lionUpdate = lion.getImage();
        Image newLion = lionUpdate.getScaledInstance(125,80,Image.SCALE_SMOOTH);
        lion = new ImageIcon(newLion);

        //creates real board state in array
        drawBoard();
        //updates board based on location around character
        //sets player character on random tile and adds that tile to the visited tile list
        squares[row][col].setIcon(karateka);
        squares[row][col].setName("Player");
        //make it so boss cannot be put on the players tile
        if (bossRow == row && row == 0){
            bossRow +=1;
        }
        else if (bossRow == row){
            bossRow = bossRow -1;
        }
        //hides the tile where we put the boss, but assigns it the Final Boss name so we know what type of tile it is
        squares[bossRow][bossCol].setIcon(black);
        squares[bossRow][bossCol].setName("Final Boss");
        //adds the tile we start on to the players knowledge of what tiles he knows (these tiles are visible)
        myChar.addTile(row,col);
        updateBoard();
    }

    //size of game board dimension
    int sizeMatrix = 10;
    //adding the interactive game part to the JPanel gameboard
    //The JButton array squares holds the gameboard based on current visibility state
    public JButton[][] squares = new JButton[sizeMatrix][sizeMatrix];

    //Upper left corner of board is (0,0)
    //Create random numbers so the game can start in different cells each time
    Random rand = new Random();
    //Generates random numbers from 0 to 9 in this case
    int row = rand.nextInt(sizeMatrix - 1);
    int col = rand.nextInt(sizeMatrix - 1);
    int bossRow = rand.nextInt(sizeMatrix -1);
    int bossCol = rand.nextInt(sizeMatrix -1);
    //Images:
    ImageIcon karateka;
    ImageIcon grass;
    ImageIcon black;
    ImageIcon shrine;
    ImageIcon energy;
    ImageIcon healthpack;
    ImageIcon quicksand;
    ImageIcon easyEnemy;
    ImageIcon mediumEnemy;
    ImageIcon hardEnemy;
    ImageIcon boss;
    ImageIcon lion;


    //Method that updates the board when a player moves to keep track of player visibilty and saved space knowledge
    //only updates if it is a valid board spot
    //always keeps player tile on his spot
    public void updateBoard(){
            for (int a = row-1; a <= row+1; a++) {
                for (int b = col - 1; b <= col + 1; b++) {
                    if (a < 0) {
                        continue;
                    } else if (a > 9) {
                        continue;
                    } else if (b < 0) {
                        continue;
                    } else if (b > 9)
                        continue;
                    else {
                        String tileName = squares[a][b].getName();
                        //checks what tile was visited to do appropriate action default is grass tile
                        switch (tileName) {
                            case "HealthPack":
                                squares[a][b].setIcon(healthpack);
                                break;
                            case "Quicksand":
                                squares[a][b].setIcon(quicksand);
                                break;
                            case "Energy":
                                squares[a][b].setIcon(energy);
                                break;
                            case "Shrine":
                                squares[a][b].setIcon(shrine);
                                break;
                            case "Player":
                                squares[a][b].setIcon(karateka);
                                break;
                            case "Easy" :
                                squares[a][b].setIcon(easyEnemy);
                                break;
                            case "Medium":
                                squares[a][b].setIcon(mediumEnemy);
                                break;
                            case "Hard":
                                squares[a][b].setIcon(hardEnemy);
                                break;
                            case "Final Boss":
                                squares[a][b].setIcon(boss);
                                break;
                            case "Lion":
                                squares[a][b].setIcon(lion);
                                break;
                            default:
                                squares[a][b].setIcon(grass);
                                break;
                        }
                    }
                }
            }
    }

    //method that creates boardstate of real game and then hides board
    public void drawBoard(){
        //Create and add board component, fills board to make sure we have enough action tiles on board, fills rest with
        //grass (empty tile)
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                //generates a random number and converts it into an int for use in the switch
                int randumNum = rand.nextInt(10-0);
                //creates switch that decides what button will be on each tile , double chance for grass blank tile
                //depending on random number a tile is assigned to a button and given that name before being hidden
                switch(randumNum){
                    case 0:
                    case 1:
                        squares[i][j] = new Grass(myChar, this);
                        squares[i][j].setName("Grass");
                        squares[i][j].setIcon(black);
                        break;
                    case 2:
                        squares[i][j] = new HealthPack(myChar, this);
                        squares[i][j].setName("HealthPack");
                        squares[i][j].setIcon(black);
                        break;
                    case 3:
                        squares[i][j] = new Quicksand(myChar, this);
                        squares[i][j].setName("Quicksand");
                        squares[i][j].setIcon(black);
                        break;
                    case 4:
                        squares[i][j] = new Energy(myChar, this );
                        squares[i][j].setName("Energy");
                        squares[i][j].setIcon(black);
                        break;
                    case 5:
                        squares[i][j] = new Shrine(myChar, this);
                        squares[i][j].setName("Shrine");
                        squares[i][j].setIcon(black);
                        break;
                    case 6:
                        squares[i][j] = new EasyEnemyButton(myChar, this, new EasyEnemy(difficultyLevel));
                        squares[i][j].setName("Easy");
                        squares[i][j].setIcon(black);
                        break;
                    case 7:
                        squares[i][j] = new MediumEnemyButton(myChar, this, new MediumEnemy(difficultyLevel));
                        squares[i][j].setName("Medium");
                        squares[i][j].setIcon(black);
                        break;
                    case 8:
                        squares[i][j] = new HardEnemyButton(myChar, this, new HardEnemy(difficultyLevel));
                        squares[i][j].setName("Hard");
                        squares[i][j].setIcon(black);
                        break;
                    case 9:
                        squares[i][j] = new Lion(myChar, this);
                        squares[i][j].setName("Lion");
                        squares[i][j].setIcon(black);
                        break;
                }
                //adds the tiles to the gameboard
                gameBoard.add(squares[i][j]);
            }
        }
    }

    //method that checks to see if player clicks on a valid button (1 square away from current position)
    private boolean isValidMove(int i, int j) {
        int rowDelta = Math.abs(i - row); //to get a positive value
        int colDelta = Math.abs(j - col);
        //to allow the movement in one square ((right,left),(up,down),diagonal)
        if ((rowDelta == 0) &&
                (colDelta == 1)) {
            return true;
        }
        if ((colDelta == 0) &&
                (rowDelta == 1)) {
            return true;
        }
        if ((colDelta == 1) &&
                (rowDelta == 1)) {
            return true;
        }
        return false;
    }

    //method that moves character and updates game if the move was valid
    //first checks to see if the tile is an enemy as we treat that situation differently, if enemy we open up a combat panel
    //and if the player is victorious the enemy is defeated and removed from the board and its tile turns to a blank grass tile
    public void processClick(int i, int j) {
        if (isValidMove(i, j) == false) {
            return;
        }

        //checks to see if tile that is a valid move is an enemy and will only update tile if enemy is defeated otherwise
        //player runs and loses energy or fights and dies and game ends

        if (squares[i][j].getName().equals("Easy")) {

            runOrFight(squares[i][j]);
            if (eEnemy.getHealth() > 0){

                //if we ran from fight then we reset the enemys run status to false and we exit the processClick method without
                //moving
                if (eEnemy.getRun()) {
                    eEnemy.resetRun();
                    return;
                }
            }
        }
        else if ((squares[i][j].getName().equals("Medium"))){

            runOrFight(squares[i][j]);
            if (mEnemy.getHealth() > 0){

                //if we ran from fight then we reset the enemys run status to false and we exit the processClick method without
                //moving
                if (mEnemy.getRun()) {
                    mEnemy.resetRun();
                    return;
                }
            }
        }
        else if (squares[i][j].getName().equals("Hard")){

            runOrFight(squares[i][j]);
            if (hEnemy.getHealth() > 0){

                //if we ran from fight then we reset the enemys run status to false and we exit the processClick method without
                //moving
                if (hEnemy.getRun()) {
                    hEnemy.resetRun();
                    return;
                }
            }
        }

        else if (squares[i][j].getName().equals("Final Boss")){

            runOrFight(squares[i][j]);
            if (finalBoss.getHealth() > 0){

                //if we ran from fight then we reset the enemys run status to false and we exit the processClick method without
                //moving
                if (finalBoss.getRun()) {
                    finalBoss.resetRun();
                    return;
                }
            }
        }
        //remove the picture of the character from the previous cell, once a tile is used it turns to grass
        squares[row][col].setName("Grass");
        //update the row and column position
        row = i;
        col = j;
        //checks to see if tile has been visited before, if so it costs no energy to move there
        if (myChar.checkTile(i, j)) { }
        //if tile hasn't been visited, then tile is added to the visited list and an action is made depending on tile
        else {
            //always do these
            myChar.addTile(i, j);
            updateEnergy();

            String tileName = squares[i][j].getName();
            //checks what tile was visited to do appropriate action default is grass tile
            switch (tileName) {
                case "HealthPack":
                    useHealthPack();
                    break;
                case "Quicksand":
                    fallInQuicksand();
                    break;
                case "Energy":
                    energyPack();
                    break;
                case "Shrine":
                    visitShrine();
                    break;
                case "Lion":
                    getAttacked();
                    break;
                default:
                    break;
            }
        }
        //updates current tile to recognize players new position
        squares[i][j].setName("Player");
    }

    //Method that reduces players energy by 1 every valid move that they make as well as updating panel and checking to
    //see if energy has reached 0 and the game has ended as a loss.
    public void updateEnergy() {
        try{
            myChar.setEnergy(myChar.getEnergy() - 1);
            this.playerEnergy.setText("Energy: " + myChar.getEnergy());
            playerChat.append("\nYour Energy has decreased by 1\n");

            if (myChar.getEnergy() < 1){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "You have lost by running out of energy");
            JOptionPane.showMessageDialog(null, "Your final score is " + myChar.getScore());
            try {
                BufferedWriter output = new BufferedWriter(new FileWriter("Scores.txt", true));
                output.newLine();
                output.append(myChar.getName() + " " + myChar.getScore());
                output.close();
            } catch(IOException ex1){
                JOptionPane.showMessageDialog(null, "Your score was unable to be added due to an error.");
            }
            dispose();

        }
    }
    //method that restores players energy for picking up an energy tile
    public void energyPack(){

        myChar.setEnergy(myChar.getEnergy() + 5);
        this.playerEnergy.setText("Energy: " + myChar.getEnergy());
        playerChat.append("\nYour Energy has been restored by 5\n");
    }

    //method that restores players health for picking up a healthpack
    public void useHealthPack(){
        //check to see if players health will be over 100(max health)
        try {
            myChar.setPlayerHealth(myChar.getPlayerHealth() + 20);
          if (myChar.getPlayerHealth() + 20 > 100){
            throw new IllegalArgumentException();
        }
          else{
              this.playerHealth.setText("Health: " + myChar.getPlayerHealth());
              playerChat.append("\nYour Health has been restored by 20\n");

          }
        } catch (IllegalArgumentException e){
            myChar.setPlayerHealth(100);
            this.playerHealth.setText("Health: " + myChar.getPlayerHealth());
            playerChat.append("\nYour Health has been restored.\n");
        }
    }

    //method that hurts player for falling in quicksand
    public void fallInQuicksand(){
        myChar.setPlayerHealth(myChar.getPlayerHealth() - 20);
        checkHealth();
        this.playerHealth.setText("Health: " + myChar.getPlayerHealth());
        playerChat.append("\nYou took 20 points of damage\nPlease be wary of quicksand!\n");
    }

    //method that lets player character visit a shrine where they can increase the attribute of their choice by 1
    public void visitShrine(){

        String[] options = new String[] {"Strength", "Defense"};
        int response = JOptionPane.showOptionDialog(null, "What attribute would you like to increase",
                "Powerful Shrine", 0, JOptionPane.QUESTION_MESSAGE, null, options, 0);
        if (response == 0){

            myChar.setPlayerStrength(myChar.getPlayerStrength() + 1);
            playerChat.append("\nYou have increased your Strength by 1!");
            playerChat.append("\nYour strength is now " + myChar.getPlayerStrength());
            playerChat.append("\n");
        }
        else{

            myChar.setPlayerDefense(myChar.getPlayerDefense() + 1);
            playerChat.append("\nYou have increased your Defense by 1!");
            playerChat.append("\nYour defense is now " + myChar.getPlayerDefense());
            playerChat.append("\n");
        }
    }

    //method that is run every time player loses health, checks to see if this drops their health below 0 and if
    // so they die ending the game
    public void checkHealth(){
        if (myChar.getPlayerHealth() <=0){
            JOptionPane.showMessageDialog(null, "You have died");
            JOptionPane.showMessageDialog(null, "Your final score is " + myChar.getScore());
            try {
                BufferedWriter output = new BufferedWriter(new FileWriter("Scores.txt", true));
                output.newLine();
                output.append(myChar.getName() + " " + myChar.getScore());
                output.close();
            } catch(IOException ex1){
                JOptionPane.showMessageDialog(null, "Your score was unable to be added due to an error.");
            }
            dispose();

        }
    }

    //method that runs combat operations and ability to run
    //method is run when the player clicks on a enemy tile, it opens up the compat panel
    public void runOrFight(JButton b) {
        JButton button = b;
        if (button.getName().equals("Easy")) {
            CombatPanel combatPanel = new CombatPanel(myChar, this, eEnemy, button);

        }
        else if (button.getName().equals("Medium")){
            CombatPanel combatPanel = new CombatPanel(myChar, this, mEnemy, button);

        }

        else if (button.getName().equals("Hard")){
            CombatPanel combatPanel = new CombatPanel(myChar, this, hEnemy, button);
        }

        else if (button.getName().equals("Final Boss")){
            CombatPanel combatPanel = new CombatPanel(myChar, this, finalBoss, button);
        }
    }
    //method that levels up character, fully heals them and increases stats by 1 and updates belt
    public void levelUp(){

        myChar.setPlayerHealth(100);
        myChar.setExperience(0);
        playerExp.setText("Experience: "+ myChar.getExperience());
        playerHealth.setText("Health: "+ myChar.getPlayerHealth());
        myChar.setPlayerStrength(myChar.getPlayerStrength() + 1);
        myChar.setPlayerDefense(myChar.getPlayerDefense() + 1);
        playerChat.append("\nYou have leveled up!\nYour strength has increased by 1\n");
        playerChat.append("Your defense has increased by 1\n");
        playerChat.append("Your health has also been restored back to 100\n");
        myChar.setBeltNum(myChar.getbeltNum()+ 1);
        avatarBelt.setIcon(myChar.updateBelt());
    }

    //method that checks the players energy to see if they have ran out and lost the game
    //is run every time the player would lose energy(moving a tile or running away)
    public void checkEnergy() {

        if (myChar.getEnergy() < 1) {

            JOptionPane.showMessageDialog(null, "You have lost by running out of energy");
            JOptionPane.showMessageDialog(null, "Your final score is " + myChar.getScore());
            try {
                BufferedWriter output = new BufferedWriter(new FileWriter("Scores.txt", true));
                output.newLine();
                output.append(myChar.getName() + " " + myChar.getScore());
                output.close();
            } catch(IOException ex1){
                JOptionPane.showMessageDialog(null, "Your score was unable to be added due to an error.");
            }
            dispose();
        }
    }
    //method that happens when you click on the lion tile and you lose 1 defense
    public void getAttacked() {
        if (myChar.getPlayerDefense() > 0) {
            myChar.setPlayerDefense(myChar.getPlayerDefense() - 1);
            playerChat.append("\nYou have been attacked by a lion!\n");
            playerChat.append("Your defense has been decreased by 1\n");
        } else {
            playerChat.append("You are lucky, the lion only grazed you!");
        }
    }
}
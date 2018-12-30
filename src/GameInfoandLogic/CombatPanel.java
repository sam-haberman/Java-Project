package GameInfoandLogic;

import Characters.*;

import javax.swing.*;
import java.awt.*;

//This class is the JFrame that holds the CombatPanel which is the interface for when our player enters into combat
//with an enemy

public class CombatPanel extends JFrame {

    //Instantiate classes for everything that will be passed into the combat panel and used in the constructors
    Player myChar;
    GameBoard gameBoard;
    EasyEnemy eEnemy;
    MediumEnemy mEnemy;
    HardEnemy hEnemy;
    FinalBoss boss;
    JButton button;
    //overall panel
    JPanel fightOrRunPanel = new JPanel();
    //panel holding players information and the fight button
    JPanel playerStatsAndFight = new JPanel();
    //panel holding enemy information and the run button
    JPanel enemyStatsAndRun = new JPanel();
    //panel holding combat chat information
    JPanel combatChat = new JPanel();
    //combat chat textarea
    JTextArea combat = new JTextArea(35, 25);
    //scrollbar for combat textarea
    JScrollPane playerScroll = new JScrollPane(combat, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //Label that displays users Health
    JLabel playerHealth = new JLabel();
    //JLabels that use character stats to fill grid
    JLabel avatarPic = new JLabel();
    //Create Panel that holds attributes placed in playerinfo panel
    JPanel playerAtt = new JPanel();
    //JLabel that holds players name
    JLabel playerName = new JLabel();
    //Label that displays users Strength
    JLabel playerStrength = new JLabel();
    //Label that displays users Defense
    JLabel playerDefense = new JLabel();
    //Label that displays users Experience
    JLabel playerExperience = new JLabel();
    //Label that holds enemy picture
    JLabel enemyPic = new JLabel();
    //panel that holds enemy stats
    JPanel enemyStats = new JPanel();
    //Label that shows enemys health
    JLabel enemyHealth = new JLabel();
    //Label that shows enemys strength
    JLabel enemyStrength = new JLabel();
    //Label that shows enemys defense
    JLabel enemyDefense = new JLabel();

    //sets up unique panel each time depending on who player is fighting

    //constructor for easy enemy
    public CombatPanel(Player p, GameBoard g, EasyEnemy e, JButton b) {
        super("Combat Panel");
        myChar = p;
        gameBoard = g;
        eEnemy = e;
        button = b;

        //Updating JLabels with Player and enemy stats
        avatarPic.setIcon(myChar.getAvatar());
        playerName.setText(myChar.getName());
        playerHealth.setText("Health:" + myChar.getPlayerHealth());
        playerStrength.setText("Strength: " + myChar.getPlayerStrength());
        playerDefense.setText("Defense: " + myChar.getPlayerDefense());
        playerExperience.setText("Experience " + myChar.getExperience());

        enemyPic.setIcon(eEnemy.getImage());
        enemyHealth.setText("Health: " + eEnemy.getHealth());
        enemyStrength.setText("Strength: " + eEnemy.getStrength());
        enemyDefense.setText("Defense: " + eEnemy.getDefense());

        //creates instances of run and fightbutton using our correct player and enemy information
        RunButton runButton = new RunButton(myChar, gameBoard, eEnemy, this);
        FightButton fightButton = new FightButton(myChar, gameBoard, eEnemy, this, button);

        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        fightOrRunPanel.setLayout(new BorderLayout());
        playerAtt.setLayout(new GridLayout(5, 1));

        //Add player attributes to player attribute panel
        playerAtt.add(playerName);
        playerAtt.add(playerHealth);
        playerAtt.add(playerStrength);
        playerAtt.add(playerDefense);
        playerAtt.add(playerExperience);

        //add enemy attributes to enemy panel
        enemyStats.setLayout(new GridLayout(3, 1));
        enemyStats.add(enemyHealth);
        enemyStats.add(enemyStrength);
        enemyStats.add(enemyDefense);


        //adds picture, player stats and fight button to panel
        playerStatsAndFight.setLayout(new BorderLayout());
        playerStatsAndFight.add(avatarPic, BorderLayout.NORTH);
        playerStatsAndFight.add(playerAtt, BorderLayout.CENTER);
        playerStatsAndFight.add(fightButton, BorderLayout.SOUTH);

        //adds enemy picture, stats and run button to panel
        enemyStatsAndRun.setLayout(new BorderLayout());
        enemyStatsAndRun.add(enemyPic, BorderLayout.NORTH);
        enemyStatsAndRun.add(enemyStats, BorderLayout.CENTER);
        enemyStatsAndRun.add(runButton, BorderLayout.SOUTH);
        //adds everything else to our main panel fightOrRunPanel
        combatChat.add(playerScroll);
        combat.setEditable(false);
        fightOrRunPanel.add(playerStatsAndFight, BorderLayout.WEST);
        fightOrRunPanel.add(combatChat, BorderLayout.CENTER);
        fightOrRunPanel.add(enemyStatsAndRun, BorderLayout.EAST);

        add(fightOrRunPanel);
        setVisible(true);
    }

    //constructor for MediumEnemy
    public CombatPanel(Player p, GameBoard g, MediumEnemy m, JButton b) {
        super("Combat Panel");
        myChar = p;
        gameBoard = g;
        mEnemy = m;
        button = b;

        //Updating JLabels with Player and enemy stats
        avatarPic.setIcon(myChar.getAvatar());
        playerName.setText(myChar.getName());
        playerHealth.setText("Health:" + myChar.getPlayerHealth());
        playerStrength.setText("Strength: " + myChar.getPlayerStrength());
        playerDefense.setText("Defense: " + myChar.getPlayerDefense());
        playerExperience.setText("Experience " + myChar.getExperience());

        enemyPic.setIcon(mEnemy.getImage());
        enemyHealth.setText("Health: " + mEnemy.getHealth());
        enemyStrength.setText("Strength: " + mEnemy.getStrength());
        enemyDefense.setText("Defense: " + mEnemy.getDefense());


        RunButton runButton = new RunButton(myChar, gameBoard, mEnemy, this);
        FightButton fightButton = new FightButton(myChar, gameBoard, mEnemy, this, button);

        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        fightOrRunPanel.setLayout(new BorderLayout());

        playerAtt.setLayout(new GridLayout(5, 1));
        //Add player attributes to player attribute panel
        playerAtt.add(playerName);
        playerAtt.add(playerHealth);
        playerAtt.add(playerStrength);
        playerAtt.add(playerDefense);
        playerAtt.add(playerExperience);

        enemyStats.setLayout(new GridLayout(3, 1));
        enemyStats.add(enemyHealth);
        enemyStats.add(enemyStrength);
        enemyStats.add(enemyDefense);


        //adds picture, player stats and fight button to panel
        playerStatsAndFight.setLayout(new BorderLayout());
        playerStatsAndFight.add(avatarPic, BorderLayout.NORTH);
        playerStatsAndFight.add(playerAtt, BorderLayout.CENTER);
        playerStatsAndFight.add(fightButton, BorderLayout.SOUTH);

        //adds enemy picture, stats and run button to panel
        enemyStatsAndRun.setLayout(new BorderLayout());
        enemyStatsAndRun.add(enemyPic, BorderLayout.NORTH);
        enemyStatsAndRun.add(enemyStats, BorderLayout.CENTER);
        enemyStatsAndRun.add(runButton, BorderLayout.SOUTH);

        combatChat.add(playerScroll);
        combat.setEditable(false);
        fightOrRunPanel.add(playerStatsAndFight, BorderLayout.WEST);
        fightOrRunPanel.add(combatChat, BorderLayout.CENTER);
        fightOrRunPanel.add(enemyStatsAndRun, BorderLayout.EAST);

        add(fightOrRunPanel);
        setVisible(true);
    }

    //constructor for HardEnemy
    public CombatPanel(Player p, GameBoard g, HardEnemy h, JButton b) {
        super("Combat Panel");
        myChar = p;
        gameBoard = g;
        hEnemy = h;
        button = b;

        //Updating JLabels with Player and enemy stats
        avatarPic.setIcon(myChar.getAvatar());
        playerName.setText(myChar.getName());
        playerHealth.setText("Health:" + myChar.getPlayerHealth());
        playerStrength.setText("Strength: " + myChar.getPlayerStrength());
        playerDefense.setText("Defense: " + myChar.getPlayerDefense());
        playerExperience.setText("Experience " + myChar.getExperience());

        enemyPic.setIcon(hEnemy.getImage());
        enemyHealth.setText("Health: " + hEnemy.getHealth());
        enemyStrength.setText("Strength: " + hEnemy.getStrength());
        enemyDefense.setText("Defense: " + hEnemy.getDefense());


        RunButton runButton = new RunButton(myChar, gameBoard, hEnemy, this);
        FightButton fightButton = new FightButton(myChar, gameBoard, hEnemy, this, button);

        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        fightOrRunPanel.setLayout(new BorderLayout());

        playerAtt.setLayout(new GridLayout(5, 1));
        //Add player attributes to player attribute panel
        playerAtt.add(playerName);
        playerAtt.add(playerHealth);
        playerAtt.add(playerStrength);
        playerAtt.add(playerDefense);
        playerAtt.add(playerExperience);

        enemyStats.setLayout(new GridLayout(3, 1));
        enemyStats.add(enemyHealth);
        enemyStats.add(enemyStrength);
        enemyStats.add(enemyDefense);


        //adds picture, player stats and fight button to panel
        playerStatsAndFight.setLayout(new BorderLayout());
        playerStatsAndFight.add(avatarPic, BorderLayout.NORTH);
        playerStatsAndFight.add(playerAtt, BorderLayout.CENTER);
        playerStatsAndFight.add(fightButton, BorderLayout.SOUTH);

        //adds enemy picture, stats and run button to panel
        enemyStatsAndRun.setLayout(new BorderLayout());
        enemyStatsAndRun.add(enemyPic, BorderLayout.NORTH);
        enemyStatsAndRun.add(enemyStats, BorderLayout.CENTER);
        enemyStatsAndRun.add(runButton, BorderLayout.SOUTH);

        combatChat.add(playerScroll);
        combat.setEditable(false);
        fightOrRunPanel.add(playerStatsAndFight, BorderLayout.WEST);
        fightOrRunPanel.add(combatChat, BorderLayout.CENTER);
        fightOrRunPanel.add(enemyStatsAndRun, BorderLayout.EAST);

        add(fightOrRunPanel);
        setVisible(true);

    }

    //constructor for Final Boss
    public CombatPanel(Player p, GameBoard g, FinalBoss bo, JButton b) {
        super("Combat Panel");
        myChar = p;
        gameBoard = g;
        boss = bo;
        button = b;

        //Updating JLabels with Player and enemy stats
        avatarPic.setIcon(myChar.getAvatar());
        playerName.setText(myChar.getName());
        playerHealth.setText("Health:" + myChar.getPlayerHealth());
        playerStrength.setText("Strength: " + myChar.getPlayerStrength());
        playerDefense.setText("Defense: " + myChar.getPlayerDefense());
        playerExperience.setText("Experience " + myChar.getExperience());

        enemyPic.setIcon(boss.getImage());
        enemyHealth.setText("Health: " + boss.getHealth());
        enemyStrength.setText("Strength: " + boss.getStrength());
        enemyDefense.setText("Defense: " + boss.getDefense());


        RunButton runButton = new RunButton(myChar, gameBoard, boss, this);
        FightButton fightButton = new FightButton(myChar, gameBoard, boss, this, button);

        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        fightOrRunPanel.setLayout(new BorderLayout());

        playerAtt.setLayout(new GridLayout(5, 1));
        //Add player attributes to player attribute panel
        playerAtt.add(playerName);
        playerAtt.add(playerHealth);
        playerAtt.add(playerStrength);
        playerAtt.add(playerDefense);
        playerAtt.add(playerExperience);

        enemyStats.setLayout(new GridLayout(3, 1));
        enemyStats.add(enemyHealth);
        enemyStats.add(enemyStrength);
        enemyStats.add(enemyDefense);


        //adds picture, player stats and fight button to panel
        playerStatsAndFight.setLayout(new BorderLayout());
        playerStatsAndFight.add(avatarPic, BorderLayout.NORTH);
        playerStatsAndFight.add(playerAtt, BorderLayout.CENTER);
        playerStatsAndFight.add(fightButton, BorderLayout.SOUTH);

        //adds enemy picture, stats and run button to panel
        enemyStatsAndRun.setLayout(new BorderLayout());
        enemyStatsAndRun.add(enemyPic, BorderLayout.NORTH);
        enemyStatsAndRun.add(enemyStats, BorderLayout.CENTER);
        enemyStatsAndRun.add(runButton, BorderLayout.SOUTH);

        combatChat.add(playerScroll);
        combat.setEditable(false);
        fightOrRunPanel.add(playerStatsAndFight, BorderLayout.WEST);
        fightOrRunPanel.add(combatChat, BorderLayout.CENTER);
        fightOrRunPanel.add(enemyStatsAndRun, BorderLayout.EAST);

        add(fightOrRunPanel);
        setVisible(true);
    }
}
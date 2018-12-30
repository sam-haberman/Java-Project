package GameInfoandLogic;

//This class is created to hold a new type of object called GameScore, it combines the players name and score for use in the
//highscore scoreboard
public class GameScore {
    String name;
    int score;

    public GameScore(String name, int score){
        this.name = name;
        this.score = score;
    }


    //Getters and setters
    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }
}

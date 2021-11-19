package hu.nye.progtech.java.models;

public class Player {

    private String playerName;
    private int playerWins;
    private int playerHighestScore;

    public Player(String playerName, int playerWins, int playerHighestScore) {
        this.playerName = playerName;
        this.playerWins = playerWins;
        this.playerHighestScore = playerHighestScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getPlayerHighestScore() {
        return playerHighestScore;
    }

    public void setPlayerName(String newPlayerName) {
        this.playerName = newPlayerName;
    }

    public void setPLayerWins(int newPlayerWins) {
        this.playerWins = newPlayerWins;
    }

    public void setPlayerHighestScore(int newHighestScore) {
        this.playerHighestScore = newHighestScore;
    }
}

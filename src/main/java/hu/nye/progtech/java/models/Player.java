package hu.nye.progtech.java.models;

public class Player {

    private String playerName;
    private int playerWins;
    private int playerPlayedGames;

    public Player(String playerName, int playerWins, int playerPlayedGames) {
        this.playerName = playerName;
        this.playerWins = playerWins;
        this.playerPlayedGames = playerPlayedGames;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getPlayerPlayedGames() {
        return playerPlayedGames;
    }

    public void setPlayerName(String newPlayerName) {
        this.playerName = newPlayerName;
    }

    public void setPLayerWins(int newPlayerWins) {
        this.playerWins = newPlayerWins;
    }

    public void setPlayerPlayedGames(int newPlayedGames) {
        this.playerPlayedGames = newPlayedGames;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + this.playerName + '\'' +
                ", playerWins=" + this.playerWins +
                ", playerPlayedGames=" + this.playerPlayedGames +
                '}';
    }
}

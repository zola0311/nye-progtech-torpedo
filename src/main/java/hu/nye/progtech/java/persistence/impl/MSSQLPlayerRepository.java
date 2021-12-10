package hu.nye.progtech.java.persistence.impl;

import hu.nye.progtech.java.models.Player;
import hu.nye.progtech.java.persistence.PlayerRepository;

import java.sql.*;

public class MSSQLPlayerRepository implements PlayerRepository {

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/progtechdatabase", "root", "");

    private static final String INSERT_STATEMENT = "INSERT INTO players (playerName, playerWins, playerPlayedGames) VALUES (?, ?, ?);";
    private static final String SELECT_STATEMENT = "SELECT * FROM players Where playerName = ?;";
    private static final String UPDATE_STATEMENT = "UPDATE players SET playerWins = ?, playerPlayedGames = ? Where playerName = ?;";

    private Player player;

    public MSSQLPlayerRepository(Player player) throws SQLException {
        this.player = player;
    }

    @Override
    public void createPlayer(Player player) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)){
            preparedStatement.setString(1, player.getPlayerName());
            preparedStatement.setString(2, String.valueOf(player.getPlayerWins()));
            preparedStatement.setString(3, String.valueOf(player.getPlayerPlayedGames()));
            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    @Override
    public void updatePlayer(Player player) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT)){
            preparedStatement.setString(3, player.getPlayerName());
            preparedStatement.setString(1, String.valueOf(player.getPlayerWins()));
            preparedStatement.setString(2, String.valueOf(player.getPlayerPlayedGames()));
            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    @Override
    public Player getPlayer() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATEMENT)){
            preparedStatement.setString(1, player.getPlayerName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                player.setPLayerWins(resultSet.getInt("PlayerWins"));
                player.setPlayerPlayedGames(resultSet.getInt("PlayerPlayedGames"));
            }

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return player;
    }
}

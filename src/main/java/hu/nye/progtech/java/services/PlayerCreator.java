package hu.nye.progtech.java.services;

import hu.nye.progtech.java.models.Player;
import hu.nye.progtech.java.persistence.impl.MyQLPlayerRepository;
import hu.nye.progtech.java.ui.PrintWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class PlayerCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerCreator.class);

    private static final String WELCOME_MESSAGE = "Üdvözöllek! Kérlek add meg a neved:";

    private final UserInputReader userInputReader;
    private final PrintWrapper printWrapper;

    public PlayerCreator(UserInputReader userInputReader, PrintWrapper printWrapper) {
        this.userInputReader = userInputReader;
        this.printWrapper = printWrapper;
    }

    public Player createPlayer() {

        printWrapper.printLine(WELCOME_MESSAGE);
        String playerName = userInputReader.readInput();
        Player player = new Player(null, 0, 0);
        try {
            player.setPlayerName(playerName);
            try {
                MyQLPlayerRepository playerRepository = new MyQLPlayerRepository(player);

                int playerPlayedGamesInDatabase = playerRepository.getPlayer().getPlayerPlayedGames();

                if (playerPlayedGamesInDatabase == 0) {
                    player.setPlayerPlayedGames(1);
                    playerRepository.createPlayer(player);
                    LOGGER.info("Add a new player to the database.: " + playerName);
                } else {
                    player.setPlayerPlayedGames(playerPlayedGamesInDatabase + 1);
                    playerRepository.updatePlayer(player);
                    LOGGER.info("Query and modify player information.: " + playerName);
                }
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
        catch (NullPointerException emptyPlayerName) {
            printWrapper.printLine("Helytelen játékos név.");
        }
        return player;
    }
}

package hu.nye.progtech.java.persistence;

import hu.nye.progtech.java.models.Player;

public interface PlayerRepository {

    void createPlayer(Player player);

    void updatePlayer(Player player);

    Player getPlayer();
}

package hu.nye.progtech.java;

import hu.nye.progtech.java.models.Map;
import hu.nye.progtech.java.services.GameController;
import hu.nye.progtech.java.services.GuessMapCreator;
import hu.nye.progtech.java.services.MapCreator;
import hu.nye.progtech.java.services.PlayerCreator;
import hu.nye.progtech.java.ui.MapPrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.nye.progtech.java");
        PlayerCreator playerCreator = applicationContext.getBean(PlayerCreator.class);
        playerCreator.createPlayer();

        MapCreator mapCreator = new MapCreator(10, 10);
        Map baseMapForPlayer = mapCreator.createMap();
        Map baseMapForComputer = mapCreator.createMap();

        GuessMapCreator guessMapCreator = new GuessMapCreator(10, 10);
        Map guessMapForPlayer = guessMapCreator.createMap();
        Map guessMapForComputer = guessMapCreator.createMap();

        MapPrinter mapPrinter = new MapPrinter(baseMapForPlayer, guessMapForPlayer);
        mapPrinter.printMap();

        GameController gameController = applicationContext.getBean(GameController.class);
        gameController.start();

    }
}

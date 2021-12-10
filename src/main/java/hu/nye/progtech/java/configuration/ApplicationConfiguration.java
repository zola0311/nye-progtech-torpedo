package hu.nye.progtech.java.configuration;


import hu.nye.progtech.java.models.GameState;
import hu.nye.progtech.java.services.GameController;
import hu.nye.progtech.java.services.GameStepPerformer;
import hu.nye.progtech.java.services.PlayerCreator;
import hu.nye.progtech.java.services.UserInputReader;
import hu.nye.progtech.java.services.command.InputHandler;
import hu.nye.progtech.java.ui.PrintWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserInputReader userInputReader() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return new UserInputReader(bufferedReader);
    }

    @Bean
    public PlayerCreator playerCreator(UserInputReader userInputReader, PrintWrapper printWrapper){
        return new PlayerCreator(userInputReader, printWrapper);
    }

    @Bean
    public GameController gameController(GameState gameState, GameStepPerformer gameStepPerformer) {
        return new GameController(gameState, gameStepPerformer);
    }

    @Bean
    public GameState gameState(){
        return new GameState();
    }

    @Bean
    public GameStepPerformer gameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        return new GameStepPerformer(userInputReader, inputHandler);
    }

    @Bean
    public PrintWrapper printWrapper() {
        return new PrintWrapper();
    }
}

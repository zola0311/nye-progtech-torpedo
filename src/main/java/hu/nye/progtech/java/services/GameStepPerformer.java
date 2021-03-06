package hu.nye.progtech.java.services;

import hu.nye.progtech.java.services.command.InputHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameStepPerformer {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameStepPerformer.class);

    private final UserInputReader userInputReader;
    private final InputHandler inputHandler;

    public GameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        this.userInputReader = userInputReader;
        this.inputHandler = inputHandler;
    }

    /**
     * Performs a game step.
     * <p>
     * A game step consists of taking the input from the user, then handling
     * the input.
     */
    public void performGameStep() {
        String input = userInputReader.readInput();
        LOGGER.info("Read user input = '{}'", input);
        inputHandler.handleInput(input);
    }
}

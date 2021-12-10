package hu.nye.progtech.java.services.command.impl;

import hu.nye.progtech.java.models.GameState;
import hu.nye.progtech.java.services.command.Command;
import hu.nye.progtech.java.ui.MapPrinter;
import hu.nye.progtech.java.ui.PrintWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class CShipCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExitCommand.class);
    private static final String CSHIP_COMMAND_REGEX = "^cship [A-Z] [0-9]$";
    private final GameState gameState;
    private final MapPrinter mapPrinter;
    private final PrintWrapper printWrapper;

    public CShipCommand(GameState gameState, MapPrinter mapPrinter, PrintWrapper printWrapper) {
        this.gameState = gameState;
        this.mapPrinter = mapPrinter;
        this.printWrapper = printWrapper;
    }

    @Override
    public boolean canProcess(String input) {
        return Pattern.matches(CSHIP_COMMAND_REGEX, input);
    }

    @Override
    public void process(String input) {
        String[] parts = input.split(" ");
        int rowIndex = Integer.parseInt(parts[1]);
        int columnIndex = Integer.parseInt(parts[2]);



    }
}

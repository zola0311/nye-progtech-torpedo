package hu.nye.progtech.java.configuration;

import hu.nye.progtech.java.models.GameState;
import hu.nye.progtech.java.services.command.Command;
import hu.nye.progtech.java.services.command.InputHandler;
import hu.nye.progtech.java.services.command.impl.DefaultCommand;
import hu.nye.progtech.java.services.command.impl.ExitCommand;
import hu.nye.progtech.java.ui.PrintWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommandConfiguration {

    @Bean
    public InputHandler inputHandler(List<Command> commandList) {
        return new InputHandler(commandList);
    }

    @Bean
    public ExitCommand exitCommand(GameState gameState) {
        return new ExitCommand(gameState);
    }

    @Bean
    public DefaultCommand defaultCommand(PrintWrapper printWrapper) {
        return new DefaultCommand(printWrapper);
    }
}

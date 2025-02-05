package org.gonza.javaplayground;

import org.gonza.javaplayground.core.PlayerInput;
import org.gonza.javaplayground.service.GameView;
import org.gonza.javaplayground.service.RacingGame;
import org.gonza.javaplayground.service.RacingGameRunner;
import org.gonza.javaplayground.view.ConsolePrinter;
import org.gonza.javaplayground.view.ConsoleReader;
import org.gonza.javaplayground.view.Printer;
import org.gonza.javaplayground.view.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPlaygroundApplication.class, args);

        Reader reader = new ConsoleReader();
        final Printer printer = new ConsolePrinter();
        GameView inputView = new GameView(reader, printer);
        PlayerInput playerInput = inputView.createPlayerInput();

        RacingGame racingGame = new RacingGame(playerInput.getNames());
        final RacingGameRunner racingGameRunner = new RacingGameRunner(racingGame, playerInput.getRetry(), printer);
        racingGameRunner.run();
    }
}

package org.gonza.javaplayground;

import org.gonza.javaplayground.core.PlayerInput;
import org.gonza.javaplayground.service.GameInputManager;
import org.gonza.javaplayground.service.RacingGame;
import org.gonza.javaplayground.view.ConsoleReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.gonza.javaplayground.view.ConsolePrinter.printCars;
import static org.gonza.javaplayground.view.ConsolePrinter.printWinners;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPlaygroundApplication.class, args);

        ConsoleReader reader = new ConsoleReader();
        GameInputManager inputManager = new GameInputManager(reader);
        PlayerInput playerInput = inputManager.createPlayerInput();

        RacingGame racingGame = new RacingGame(playerInput.getNames());
        racingGame.play();

        for (int i = 0; i < playerInput.getRetry(); i++) {
            racingGame.play();

            printCars(racingGame);
        }
        printWinners(racingGame.winnerNames());
    }

}

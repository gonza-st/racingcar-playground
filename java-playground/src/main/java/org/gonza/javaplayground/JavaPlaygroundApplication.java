package org.gonza.javaplayground;

import org.gonza.javaplayground.core.PlayerInput;
import org.gonza.javaplayground.service.RacingGame;
import org.gonza.javaplayground.util.Converter;
import org.gonza.javaplayground.view.ConsolePrinter;
import org.gonza.javaplayground.view.ConsoleReader;
import org.gonza.javaplayground.view.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static org.gonza.javaplayground.view.ConsolePrinter.printCars;
import static org.gonza.javaplayground.view.ConsolePrinter.printWinners;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPlaygroundApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        Reader consoleReader = new ConsoleReader(scanner);
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = consoleReader.read();
        consolePrinter.print(carNames);
        consolePrinter.print("시도할 회수는 몇회인가요?");
        String retry = consoleReader.read();
        PlayerInput playerInput = new PlayerInput(carNames, Integer.parseInt(retry));

        RacingGame racingGame = new RacingGame(Converter.separatedByCommas(carNames));
        racingGame.play();

        for (int i = 0; i < playerInput.getRetry(); i++) {
            racingGame.play();

            printCars(racingGame);
        }
        printWinners(racingGame.winnerNames());
    }

}

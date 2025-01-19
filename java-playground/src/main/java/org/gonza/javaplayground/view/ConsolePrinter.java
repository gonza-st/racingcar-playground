package org.gonza.javaplayground.view;

import org.gonza.javaplayground.core.Nickname;
import org.gonza.javaplayground.core.Position;
import org.gonza.javaplayground.service.RacingGame;

import java.util.List;

public class ConsolePrinter implements Printer {
    private static final char CAR_DISTANCE_CHARACTER = '-';
    private static final String PRINT_DELIMITER = " : ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printGameStatus(RacingGame racingGame) {
        printCarStatus(racingGame.getCarNames(), racingGame.getCarPositions());
        printNewLine();
    }

    @Override
    public void printWinners(List<String> names) {
        String winnerNames = Nickname.parseWinnerNames(names);
        print(winnerNames + WINNER_MESSAGE);
    }

    private void printCarStatus(List<String> names, List<Position> positions) {
        for (int i = 0; i < names.size(); i++) {
            printSingleCarStatus(names.get(i), positions.get(i));
        }
    }

    private void printSingleCarStatus(String name, Position position) {
        StringBuilder status = new StringBuilder()
                .append(name)
                .append(PRINT_DELIMITER)
                .append(generateDistance(position));
        print(status.toString());
    }

    private String generateDistance(Position position) {
        return "-".repeat(position.getDistance());
    }

    private void printNewLine() {
        System.out.println();
    }
}

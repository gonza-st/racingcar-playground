package org.gonza.javaplayground.view;

import org.gonza.javaplayground.core.Position;

import java.util.List;
import java.util.stream.Collectors;

public class ConsolePrinter implements Printer {
    private static final char CAR_DISTANCE_CHARACTER = '-';
    private static final String PRINT_DELIMITER = " : ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printGameStatus(List<String> carNames, List<Position> carPositions) {
        printCarStatus(carNames, carPositions);
        printNewLine();
    }

    @Override
    public void printWinners(List<String> names) {
        print(names.stream()
                .collect(Collectors.joining(",")) + WINNER_MESSAGE);
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
                .append(printDistance(position));
        print(status.toString());
    }

    private String printDistance(Position position) {
        return "-".repeat(position.getDistance());
    }

    private void printNewLine() {
        System.out.println();
    }
}

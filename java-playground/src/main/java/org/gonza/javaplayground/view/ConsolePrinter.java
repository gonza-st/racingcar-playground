package org.gonza.javaplayground.view;

import org.gonza.javaplayground.core.Nickname;
import org.gonza.javaplayground.core.Position;
import org.gonza.javaplayground.service.RacingGame;

import java.util.List;

public class ConsolePrinter implements Printer {
    private static final char CAR_DISTANCE_CHARACTER = '-';
    private static final String PRINT_DELIMITER = " : ";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    public static void printCars(RacingGame cars) {
        printCars(cars.getCarNames(), cars.getCarPositions());
        printNewLine();
    }

    public static void printWinners(List<String> names) {
        final String winnerNames = Nickname.parseWinnerNames(names);

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public static void printNewLine() {
        System.out.println();
    }

    private static void printCars(List<String> names, List<Position> positions) {
        final int size = names.size();

        for (int i = 0; i < size; i++) {
            System.out.print(names.get(i));
            System.out.print(PRINT_DELIMITER);
            printPositions(positions.get(i));
            printNewLine();
        }
    }

    private static void printPositions(Position position) {
        for (int i = 0; i < position.getDistance(); i++) {
            System.out.print(CAR_DISTANCE_CHARACTER);
        }
    }
}

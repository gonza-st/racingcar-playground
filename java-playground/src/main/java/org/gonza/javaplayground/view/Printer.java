package org.gonza.javaplayground.view;

import org.gonza.javaplayground.service.RacingGame;

import java.util.List;

public interface Printer {
    void print(String message);

    void printGameStatus(RacingGame racingGame);

    void printWinners(List<String> names);
}

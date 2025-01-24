package org.gonza.javaplayground.view;

import org.gonza.javaplayground.core.Position;

import java.util.List;

public interface Printer {
    void print(String message);

    void printGameStatus(List<String> carNames, List<Position> carPositions);

    void printWinners(List<String> names);
}

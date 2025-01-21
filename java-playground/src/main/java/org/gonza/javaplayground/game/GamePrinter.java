package org.gonza.javaplayground.game;

import java.util.List;

public interface GamePrinter {
    void showDistance(String carName, Integer distance);

    void showResult(List<String> carNames);
}

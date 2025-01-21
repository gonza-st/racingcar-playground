package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.GamePrinter;
import org.gonza.javaplayground.io.handler.OutputHandler;

import java.util.List;

public class GamePrinterImpl implements GamePrinter {
    private static final String DISTANCE_SEPARATOR = ":";
    private static final String RESULT_SEPARATOR = ", ";

    private final OutputHandler outputHandler;

    public GamePrinterImpl(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    @Override
    public void showDistance(String carName, Integer distance) {
        String message = carName + DISTANCE_SEPARATOR + distance;
        outputHandler.println(message);
    }

    @Override
    public void showResult(List<String> carNames) {
        String message = carNames.stream()
                .reduce((acc, cur) -> acc + RESULT_SEPARATOR + cur)
                .orElse("");

        if (message.isBlank()) {
            throw new IllegalStateException("message can not be empty");
        }

        outputHandler.println(message);
    }
}

package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.count.RacingCountReader;
import org.gonza.javaplayground.io.handler.InputHandler;
import org.gonza.javaplayground.io.handler.OutputHandler;

import java.util.Objects;

public class RacingCountReaderImpl implements RacingCountReader {
    private static final String INT_GUIDE_MSG = "시도할 회수는 몇회인가요?";
    private static final Integer MIN_COUNT = 1;

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingCountReaderImpl(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public Integer getRacingCount() {
        outputHandler.println(INT_GUIDE_MSG);
        Integer count = inputHandler.getIntegerInput();

        if (Objects.isNull(count)) {
            throw new IllegalArgumentException("count can not be null");
        }

        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("count can not be less than zero");
        }

        return count;
    }
}

package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.count.RacingCountReader;
import org.gonza.javaplayground.io.handler.InputHandler;

import java.util.Objects;

public class RacingCountReaderImpl implements RacingCountReader {
    private static final String INT_GUIDE_MSG = "시도할 회수는 몇회인가요?";
    private static final Integer MIN_COUNT = 1;

    private final InputHandler inputHandler;

    public RacingCountReaderImpl(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public Integer getRacingCount() {
        Integer count = inputHandler.getIntegerInputWithGuideMsg(INT_GUIDE_MSG);

        if (Objects.isNull(count)) {
            throw new IllegalArgumentException("count can not be null");
        }

        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("count can not be less than zero");
        }

        return count;
    }
}

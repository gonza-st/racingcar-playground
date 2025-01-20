package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.CarNameReader;
import org.gonza.javaplayground.io.handler.InputHandler;

import java.util.Objects;

public class CarNameReaderImpl implements CarNameReader {
    private static final String NAME_GUIDE_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final InputHandler inputHandler;

    public CarNameReaderImpl(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public String getCarNames() {
        String carNameInput = inputHandler.getStringInput(NAME_GUIDE_MSG);

        if (Objects.isNull(carNameInput) || carNameInput.isBlank()) {
            throw new IllegalArgumentException("Wrong car names");
        }

        String trimmedInput = carNameInput.trim();
        return trimmedInput;
    }
}

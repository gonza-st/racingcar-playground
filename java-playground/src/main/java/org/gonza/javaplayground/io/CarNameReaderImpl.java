package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.car.CarNameReader;
import org.gonza.javaplayground.io.handler.InputHandler;
import org.gonza.javaplayground.io.handler.OutputHandler;

import java.util.List;
import java.util.Objects;

/**
 * 서비스 로직이 혼재함
 * 이름이 ReaderImpl인 것부터 문제인듯
 * Adapter는 이름부터 Adapter로 짓고 비즈니스 로직이 섞이지 않도록.
 */
public class CarNameReaderImpl implements CarNameReader {
    private static final String SEPARATOR = ",";
    private static final String NAME_GUIDE_MSG =
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(" + SEPARATOR + ")를 기준으로 구분).";

    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;

    public CarNameReaderImpl(OutputHandler outputHandler, InputHandler inputHandler) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
    }

    @Override
    public List<String> getCarNames() {
        outputHandler.println(NAME_GUIDE_MSG);
        String carNameInput = inputHandler.getStringInput();

        if (Objects.isNull(carNameInput) || carNameInput.isBlank()) {
            throw new IllegalArgumentException("Wrong car names");
        }

        // TODO("이 로직은 CarService로 이동해야할 듯")
        String[] carNames = carNameInput.trim().split(SEPARATOR);
        List<String> carNameList = List.of(carNames);
        return carNameList;
    }
}

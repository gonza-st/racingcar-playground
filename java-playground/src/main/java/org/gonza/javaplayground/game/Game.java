package org.gonza.javaplayground.game;

import java.util.*;

public class Game {
    private static final String NAME_GUIDE_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INT_GUIDE_MSG = "시도할 회수는 몇회인가요?";

    private final Random random;

    private final InputHandler inputHandler;

    private final OutputHandler outputHandler;

    private final GameRecord record = new GameRecord();

    public Game(Random random, InputHandler inputHandler, OutputHandler outputHandler) {
        this.random = random;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void race() {
        Integer count = inputHandler.getIntegerInput(INT_GUIDE_MSG);
        String cars = inputHandler.getStringInput(NAME_GUIDE_MSG);
        String[] carNames = cars.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name too long");
            }
        }

        while (count > 0) {
            for (int i = 0; i < carNames.length; i++) {
                String carName = carNames[i];
                Integer distance = random.nextInt(10) + 1;

                if (distance >= 4) {
                    Integer newCount = record.plusMoveCount(carName);
                    outputHandler.println(carName + ":" + (newCount));
                } else {
                    Integer prevCount = record.getMoveCount(carName);
                    outputHandler.println(carName + ":" + (prevCount));
                }
            }

            count -= 1;
        }

        List<String> carNamesWithLargestMoveCount = record.getCarWithLargestMoveCount();
        String winners = carNamesWithLargestMoveCount.stream()
                .reduce((acc, cur) -> acc + "," + cur)
                .orElseThrow(() -> new IllegalStateException("An error occurred while searching for winner"));

        outputHandler.println(winners);
    }
}

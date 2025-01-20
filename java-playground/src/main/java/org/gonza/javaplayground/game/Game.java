package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.record.GameRecord;
import org.gonza.javaplayground.io.handler.InputHandler;

import java.util.*;

public class Game {
    private final Random random;

    private final CarNameReader carNameReader;

    private final RacingCountReader racingCountReader;

    private final OutputHandler outputHandler;

    private final GameRecord record = new GameRecord();

    public Game(Random random, CarNameReader carNameReader, RacingCountReader racingCountReader, OutputHandler outputHandler) {
        this.random = random;
        this.carNameReader = carNameReader;
        this.racingCountReader = racingCountReader;
        this.outputHandler = outputHandler;
    }

    public void race() {
        Integer count = racingCountReader.getRacingCount();
        String cars = carNameReader.getCarNames();
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

package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.record.GameRecord;
import java.util.*;

public class Game {
    private final Random random;

    private final CarNameReader carNameReader;

    private final RacingCountReader racingCountReader;

    private final GamePrinter gamePrinter;

    private final GameRecord record = new GameRecord();

    public Game(Random random, CarNameReader carNameReader, RacingCountReader racingCountReader, GamePrinter gamePrinter) {
        this.random = random;
        this.carNameReader = carNameReader;
        this.racingCountReader = racingCountReader;
        this.gamePrinter = gamePrinter;
    }

    public void race() {
        Integer count = racingCountReader.getRacingCount();
        String[] carNames = getCarNames();

        while (count > 0) {
            for (int i = 0; i < carNames.length; i++) {
                String carName = carNames[i];
                Integer distance = random.nextInt(10) + 1;

                if (distance >= 4) {
                    Integer newCount = record.plusMoveCount(carName);
                    gamePrinter.showDistance(carName, newCount);
                } else {
                    Integer prevCount = record.getMoveCount(carName);
                    gamePrinter.showDistance(carName, prevCount);
                }
            }

            count -= 1;
        }


        List<String> carNamesWithLargestMoveCount = record.getCarWithLargestMoveCount();
        gamePrinter.showResult(carNamesWithLargestMoveCount);
    }

    private String[] getCarNames() {
        List<String> carNames = carNameReader.getCarNames();

        carNames.forEach((carName) -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name too long");
            }
        });

        String[] result = carNames.toArray(new String[carNames.size()]);
        return result;
    }
}

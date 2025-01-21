package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.car.CarName;
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
        List<CarName> carNames = getCarNames();

        while (count > 0) {
            for (int i = 0; i < carNames.size(); i++) {
                String carName = carNames.get(i).getValue();
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

    private List<CarName> getCarNames() {
        List<String> carNamesAsString = carNameReader.getCarNames();
        List<CarName> carNames = carNamesAsString.stream()
                .map(CarName::new)
                .toList();

        return carNames;
    }
}

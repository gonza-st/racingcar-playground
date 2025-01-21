package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.car.Car;
import org.gonza.javaplayground.game.record.GameRecord;
import java.util.*;

public class Game {
    private final CarNameReader carNameReader;

    private final RacingCountReader racingCountReader;

    private final GamePrinter gamePrinter;

    private final GameRecord record = new GameRecord();

    public Game(CarNameReader carNameReader, RacingCountReader racingCountReader, GamePrinter gamePrinter) {
        this.carNameReader = carNameReader;
        this.racingCountReader = racingCountReader;
        this.gamePrinter = gamePrinter;
    }

    public void race() {
        Integer count = racingCountReader.getRacingCount();
        List<Car> cars = getCars();

        while (count > 0) {
            for (int i = 0; i < cars.size(); i++) {
                String carName = cars.get(i).getName();
                Integer distance = cars.get(i).move();

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

    private List<Car> getCars() {
        List<String> carNamesAsString = carNameReader.getCarNames();
        List<Car> cars = carNamesAsString.stream()
                .map(Car::new)
                .toList();

        return cars;
    }
}

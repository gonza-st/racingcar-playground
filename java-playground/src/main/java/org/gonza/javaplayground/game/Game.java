package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.car.Car;
import org.gonza.javaplayground.game.record.GameRecord;
import java.util.*;

public class Game {
    private final CarService carService;

    private final RacingCountReader racingCountReader;

    private final GamePrinter gamePrinter;

    private final GameRecord record = new GameRecord();

    public Game(CarService carService, RacingCountReader racingCountReader, GamePrinter gamePrinter) {
        this.carService = carService;
        this.racingCountReader = racingCountReader;
        this.gamePrinter = gamePrinter;
    }

    public void race() {
        Integer count = racingCountReader.getRacingCount();
        List<Car> cars = carService.createCars();

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
}

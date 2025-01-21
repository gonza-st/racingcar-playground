package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.car.Car;
import org.gonza.javaplayground.game.car.CarService;
import org.gonza.javaplayground.game.record.GameRecord;
import org.gonza.javaplayground.game.round.RacingCount;
import org.gonza.javaplayground.game.round.RacingCountService;

import java.util.*;

public class Game {
    private final CarService carService;

    private final RacingCountService racingCountService;

    private final GamePrinter gamePrinter;

    private final GameRecord record = new GameRecord();

    public Game(CarService carService, RacingCountService racingCountService, GamePrinter gamePrinter) {
        this.carService = carService;
        this.racingCountService = racingCountService;
        this.gamePrinter = gamePrinter;
    }

    public void race() {
        RacingCount count = racingCountService.createRacingCount();
        List<Car> cars = carService.createCars();

        while (count.isAvailable()) {
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

            count.consume();
        }


        List<String> carNamesWithLargestMoveCount = record.getCarWithLargestMoveCount();
        gamePrinter.showResult(carNamesWithLargestMoveCount);
    }
}

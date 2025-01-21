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

    private final GameRecord record;

    public Game(
            CarService carService,
            RacingCountService racingCountService,
            GamePrinter gamePrinter
    ) {
        this.carService = carService;
        this.racingCountService = racingCountService;
        this.gamePrinter = gamePrinter;
        this.record = new GameRecord();
    }

    public void race() {
        RacingCount count = racingCountService.createRacingCount();
        List<Car> cars = carService.createCars();

        while (count.isAvailable()) {
            cars.stream()
                    .peek(this::recordRaceResultByCar)
                    .forEach(this::printRaceResultByCar);

            count.consume();
        }

        printGameResult();
    }

    private void recordRaceResultByCar(Car car) {
        if (car.move() >= 4) {
            record.plusMoveCount(car.getName());
        }
    }

    private void printRaceResultByCar(Car car) {
        String carName = car.getName();
        Integer result = record.getMoveCount(carName);

        gamePrinter.showDistance(carName, result);
    }

    private void printGameResult() {
        List<String> winners = record.getCarWithLargestMoveCount();
        gamePrinter.showResult(winners);
    }
}

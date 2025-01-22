package org.gonza.javaplayground.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.gonza.javaplayground.util.Random;

public class Game {
    private Cars cars;
    private int round;

    public Game() {
    }

    public Game setup() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String carNames = sc.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int round = sc.nextInt();
        sc.close();

        Cars cars = new Cars(carNames);
        System.out.println(Arrays.toString(cars.getCars().toArray()));

        this.cars = cars;
        this.round = round;

        return this;
    }

    public void play() {
        System.out.println("\n실행 결과");

        for (int i = 0; i < this.getRound(); i++) {
            for (Car car : this.getCars().getCars()) {
                randomMoveCar(car);
                System.out.println(car.getName() + ": " + "-".repeat(car.getLocation()));
            }
            System.out.println();
        }
        this.endGame();
    }

    public void endGame() {
        this.getWinner().forEach(car -> {
            System.out.print(car.getName());
        });
        System.out.println("가 승리하였습니다!.");
    }

    public ArrayList<Car> getWinner() {
        ArrayList<Car> winners = new ArrayList<Car>();

        cars.getCars().sort((car1, car2) -> car2.getLocation().compareTo(car1.getLocation()));

        int topLocation = cars.getCars().getFirst().getLocation();

        for (Car car : cars.getCars()) {
            if (car.getLocation() == topLocation) {
                winners.add(car);
            }
        }

        return winners;
    }

    private static void randomMoveCar(Car car) {
        Integer random = Random.between(0, 9);
        if (Car.isPossibleMovingForward(random)) {
            car.moveForward();
        }
    }

    public int getRound() {
        return round;
    }

    public Cars getCars() {
        return cars;
    }
}

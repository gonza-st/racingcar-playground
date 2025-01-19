package org.gonza.javaplayground;

import java.io.PrintStream;
import java.util.*;

public class Game {
    private static final String NAME_GUIDE_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final PrintStream printStream;
    private final Random random;

    private final InputHandler inputHandler;

    private final Map<String, Integer> record = new HashMap<>();

    public Game(PrintStream printStream, Random random, InputHandler inputHandler) {
        this.printStream = printStream;
        this.random = random;
        this.inputHandler = inputHandler;
    }

    public void race() {
        Integer count = inputHandler.getRacingCount();
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
                    Integer history = record.getOrDefault(carName, 0);
                    printStream.println(carName + ":" + (1 + history));
                    record.put(carName, 1 + history);
                } else {
                    Integer history = record.getOrDefault(carName, 0);
                    printStream.println(carName + ":" + (history));
                }
            }

            count -= 1;
        }

        Integer maxDistance = 0;
        String[] winners = new String[0];

        for (Map.Entry<String, Integer> entry : record.entrySet()) {
            Integer distance = entry.getValue();
            String carName = entry.getKey();

            if (distance > maxDistance) {
                maxDistance = distance;
                winners = new String[]{carName};
            } else if (distance == maxDistance) {
                String[] winnersCopy = Arrays.copyOf(winners, winners.length + 1);
                winnersCopy[winnersCopy.length - 1] = carName;
                winners = winnersCopy;
            }
        }

        String[] winnersOrdered = Arrays.copyOf(winners, winners.length);
        Arrays.sort(winnersOrdered);

        String winnerSentence = "";
        for (int i = 0; i < winnersOrdered.length; i++) {
            if (i == 0) {
                winnerSentence += winnersOrdered[i];
            } else {
                winnerSentence += "," + winnersOrdered[i];
            }
        }

        printStream.println(winnerSentence);
    }
}

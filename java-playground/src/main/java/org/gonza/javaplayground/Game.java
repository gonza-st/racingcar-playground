package org.gonza.javaplayground;

import java.io.PrintStream;
import java.util.*;

public class Game {
    private final PrintStream printStream;
    private final Scanner scanner;
    private final Random random;

    private final Map<String, Integer> record = new HashMap<>();

    public Game(PrintStream printStream, Scanner scanner, Random random) {
        this.printStream = printStream;
        this.scanner = scanner;
        this.random = random;
    }

    public void race() {
        Integer count = scanner.nextInt();
        String cars = scanner.nextLine();
        String[] carNames = cars.split(",");

        while (count > 0) {
            for (int i = 0; i < carNames.length; i++) {
                String carName = carNames[i];
                Integer distance = random.nextInt(10) + 1;

                Integer history = record.getOrDefault(carName, 0);

                printStream.println(carName + ":" + (distance + history));
                record.put(carName, distance + history);
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

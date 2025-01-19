package org.gonza.javaplayground;

import java.io.PrintStream;
import java.util.Scanner;

public class Game {
    private final PrintStream printStream;
    private final Scanner scanner;

    public Game(PrintStream printStream, Scanner scanner) {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    public void race() {
        Integer count = scanner.nextInt();
        String cars = scanner.nextLine();
        String[] carNames = cars.split(",");

        while (count > 0) {
            for (int i = 0; i < carNames.length; i++) {
                printStream.println(carNames[i]);
            }

            count -= 1;
        }

        printStream.println("result");
    }
}

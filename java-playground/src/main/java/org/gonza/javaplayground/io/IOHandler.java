package org.gonza.javaplayground.io;

import org.gonza.javaplayground.InputHandler;

import java.io.PrintStream;
import java.util.Scanner;

public class IOHandler implements InputHandler {
    private final Scanner scanner;
    private final PrintStream printStream;

    public IOHandler(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    @Override
    public String getStringInput(String guideMessage) {
        try {
            printStream.println(guideMessage);
            return scanner.nextLine();
        } catch (Exception e) {
            return this.getStringInput(guideMessage);
        }
    }

    @Override
    public Integer getRacingCount() {
        return 0;
    }
}

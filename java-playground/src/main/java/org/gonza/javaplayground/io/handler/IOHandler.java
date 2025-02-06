package org.gonza.javaplayground.io.handler;

import java.io.PrintStream;
import java.util.Scanner;

public class IOHandler implements InputHandler, OutputHandler {
    private final Scanner scanner;
    private final PrintStream printStream;

    public IOHandler(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    @Override
    public String getStringInputWithGuideMsg(String guideMessage) {
        try {
            printStream.println(guideMessage);
            return scanner.nextLine();
        } catch (Exception e) {
            return this.getStringInputWithGuideMsg(guideMessage);
        }
    }

    @Override
    public Integer getIntegerInputWithGuideMsg(String guideMessage) {
        try {
            printStream.println(guideMessage);
            return scanner.nextInt();
        } catch (Exception e) {
            return this.getIntegerInputWithGuideMsg(guideMessage);
        }
    }

    @Override
    public void println(String text) {
        printStream.println(text);
    }
}

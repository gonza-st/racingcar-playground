package org.gonza.javaplayground.view;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String read() {
        return SCANNER.nextLine();
    }

    public int readNumber() {
        return SCANNER.nextInt();
    }
}

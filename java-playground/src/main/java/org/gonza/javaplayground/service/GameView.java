package org.gonza.javaplayground.service;

import org.gonza.javaplayground.core.PlayerInput;
import org.gonza.javaplayground.util.Converter;
import org.gonza.javaplayground.view.Printer;
import org.gonza.javaplayground.view.Reader;

import java.util.List;

public class GameView {
    private final Reader reader;
    private final Printer printer;

    public GameView(Reader reader, final Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public PlayerInput createPlayerInput() {
        List<String> validCarNames = receiveValidCarNames();
        int validRetryCount = receiveValidRetryCount();

        return new PlayerInput(validCarNames, validRetryCount);
    }

    private List<String> receiveValidCarNames() {
        printer.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return readUntilValidCarNames();
    }

    private List<String> readUntilValidCarNames() {
        try {
            return parseCarNames(reader.read());
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            printer.print("다시 입력해 주세요.");
            return readUntilValidCarNames();
        }
    }

    private List<String> parseCarNames(String input) {
        return Converter.separatedByCommas(input);
    }

    private int receiveValidRetryCount() {
        printer.print("시도할 회수는 몇 회 인가요?");
        return readUntilValidRetryCount();
    }

    private int readUntilValidRetryCount() {
        try {
            return parseRetryCount(reader.read());
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            printer.print("다시 입력해 주세요.");
            reader.read();
            return readUntilValidRetryCount();
        }
    }

    private int parseRetryCount(String input) {
        int count = Integer.parseInt(input);
        return count;
    }
}

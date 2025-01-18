package org.gonza.javaplayground.service;

import org.gonza.javaplayground.core.PlayerInput;
import org.gonza.javaplayground.util.Converter;
import org.gonza.javaplayground.view.ConsoleReader;

import java.util.List;

public class GameInputManager {
    private final ConsoleReader reader;

    public GameInputManager(ConsoleReader reader) {
        this.reader = reader;
    }

    public PlayerInput createPlayerInput() {
        List<String> validCarNames = receiveValidCarNames();
        int validRetryCount = receiveValidRetryCount();

        return new PlayerInput(validCarNames, validRetryCount);
    }

    private List<String> receiveValidCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        while (true) {
            try {
                String input = reader.read();
                final List<String> carList = Converter.separatedByCommas(input);
                return carList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    private int receiveValidRetryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        while (true) {
            try {
                int count = reader.readNumber();
                if (count >= PlayerInput.MINIMUM_RETRY_LIMIT) {
                    return count;
                }
                throw new IllegalArgumentException("재시도 횟수는 0 미만일 수 없습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
                reader.read(); // 버퍼 비우기
            }
        }
    }
}

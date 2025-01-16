package org.gonza.javaplayground.core;

import org.gonza.javaplayground.util.Converter;

import java.util.List;

public class PlayerInput {
    public static final int MINIMUM_RETRY_LIMIT = 0;
    public static final int MINIMUM_CARS = 2;

    private String names;
    private int retry;

    public PlayerInput(String names, int retry) {
        validateNames(names);
        validateRetry(retry);
        this.names = names;
        this.retry = retry;
    }

    private void validateNames(String names) {
        List<String> carNames = Converter.separatedByCommas(names);
        if (carNames.size() < MINIMUM_CARS) {
            throw new IllegalArgumentException("경주할 자동차는 최소 2대 이상이어야 합니다.");
        }
    }

    private void validateRetry(int retry) {
        if (retry < MINIMUM_RETRY_LIMIT) {
            throw new IllegalArgumentException("재시도 횟수는 0미만일 수 없습니다.");
        }
    }

    public String getNames() {
        return names;
    }

    public int getRetry() {
        return retry;
    }
}

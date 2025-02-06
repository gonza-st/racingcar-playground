package org.gonza.javaplayground.core;


import java.util.List;

public class PlayerInput {
    public static final int MINIMUM_RETRY_LIMIT = 0;
    public static final int MINIMUM_CARS = 2;

    private List<String> names;
    private int retry;

    public PlayerInput(List<String> names, int retry) {
        validateNames(names);
        validateRetry(retry);
        this.names = names;
        this.retry = retry;
    }

    public int getRetry() {
        return retry;
    }

    public List<String> getNames() {
        return names;
    }

    private void validateNames(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("자동차 이름 목록이 null일 수 없습니다.");
        }
        if (names.size() < MINIMUM_CARS) {
            throw new IllegalArgumentException("경주할 자동차는 최소 2대 이상이어야 합니다.");
        }
    }

    private void validateRetry(int retry) {
        if (retry <= MINIMUM_RETRY_LIMIT) {
            throw new IllegalArgumentException("재시도 횟수는 0이상이어야 합니다.");
        }
    }
}

package org.gonza.javaplayground.game.record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameRecord {
    private static final Integer DEFAULT_COUNT = 0;
    private final Map<String, Integer> record = new HashMap<>();

    public Integer getMoveCount(String carName) {
        Integer count = record.getOrDefault(carName, DEFAULT_COUNT);

        if (Objects.equals(count, DEFAULT_COUNT)) {
            record.put(carName, DEFAULT_COUNT);
        }

        return count;
    }

    public Integer plusMoveCount(String carName) {
        Integer count = this.getMoveCount(carName);
        Integer newCount = count + 1;

        record.put(carName, newCount);

        return newCount;
    }

    public List<String> getCarWithLargestMoveCount() {
        Integer maxCount = record.values().stream()
                .max(Integer::compareTo)
                .orElse(DEFAULT_COUNT);

        List<String> carNames = record.entrySet().stream()
                .filter((entry) -> entry.getValue().equals(maxCount))
                .map(Map.Entry::getKey)
                .sorted()
                .toList();

        return carNames;
    }

}

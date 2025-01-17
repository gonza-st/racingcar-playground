package org.gonza.javaplayground.core;

import java.util.List;
import java.util.stream.Collectors;

public class Nickname {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Nickname(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static String parseWinnerNames(List<String> names) {
        return names.stream().collect(Collectors.joining(","));
    }

    private void validateName(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
}

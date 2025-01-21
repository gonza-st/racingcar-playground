package org.gonza.javaplayground.game.car;

import java.util.Objects;

public class CarName {
    private static final Integer MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if (Objects.isNull(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name is too long");
        }

        this.name = name;
    }

    public String getValue() {
        return name;
    }
}

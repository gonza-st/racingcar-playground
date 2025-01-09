package org.gonza.javaplayground.core;

import org.springframework.util.Assert;

class Car {
    private String name;
    private Position position;

    public Car(String name, Position position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    private static void validateName(String name) {
        Assert.hasText(name, "이름은 필수입니다.");
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

}

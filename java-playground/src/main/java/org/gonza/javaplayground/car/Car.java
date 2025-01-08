package org.gonza.javaplayground.car;

public class Car {
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Car name must not exceed 5 characters");
        }
    }
}

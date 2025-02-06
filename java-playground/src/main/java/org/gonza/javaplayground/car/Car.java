package org.gonza.javaplayground.car;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position++;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Car name must not exceed 5 characters");
        }
    }

    public String report() {
        String dashByPosition = "-".repeat(Math.max(0, this.position));
        return String.format("%s : %s", this.name, dashByPosition);
    }
}

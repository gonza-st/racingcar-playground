package org.gonza.javaplayground.core;

public class Car {
    private final Nickname nickname;
    private Position position;

    public Car(String name) {
        this.nickname = new Nickname(name);
        this.position = new Position();
    }

    public String getNickName() {
        return nickname.getName();
    }

    public Position getPosition() {
        return position;
    }

    public void forward(int randomNumber) {
        position.increase(randomNumber);
    }
}

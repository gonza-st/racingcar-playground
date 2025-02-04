package org.gonza.javaplayground.core;

public class Car {
    private Nickname nickname;
    private Position position;

    public Car(Nickname nickname, Position position) {
        this.nickname = nickname;
        this.position = position;
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

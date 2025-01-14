package org.gonza.javaplayground.core;

class Car {
    private Nickname nickname;
    private Position position;

    public Car(Nickname nickname, Position position) {
        this.nickname = nickname;
        this.position = position;
    }

    public Nickname getNickName() {
        return nickname;
    }

    public Position getPosition() {
        return position;
    }

}

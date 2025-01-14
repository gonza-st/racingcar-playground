package org.gonza.javaplayground.core;

class Nickname {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Nickname(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}

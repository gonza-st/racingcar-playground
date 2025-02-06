package org.gonza.javaplayground.util;

import java.util.Random;

public class NumberGenerator {
    private NumberGenerator() throws InstantiationException {
        throw new InstantiationException("유틸리티 클래스는 인스턴스화 할 수 없습니다.");
    }

    public static int generateRandomNumber() {
        return new Random().nextInt(10);
    }
}

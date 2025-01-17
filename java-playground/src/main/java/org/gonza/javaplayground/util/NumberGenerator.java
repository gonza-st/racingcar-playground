package org.gonza.javaplayground.util;

import java.util.Random;

public class NumberGenerator {
    public static int generateRandomNumber() {
        return new Random().nextInt(10);
    }
}

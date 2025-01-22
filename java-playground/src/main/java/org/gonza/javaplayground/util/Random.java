package org.gonza.javaplayground.util;

public class Random {
    public static Integer between(int n, int m) {
        return (int) (Math.random() * (m - n + 1) + n);
    }
}

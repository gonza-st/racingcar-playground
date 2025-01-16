package org.gonza.javaplayground.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static final String COMMAS = ",";
    public static final int NUMBER_WHEN_NOT_SEPARATED = 1;

    public Converter() {
        throw new IllegalStateException("유틸리티 클래스는 인스턴스화 할 수 없습니다.");
    }

    public static List<String> separatedByCommas(String input) {
        String[] separatedInputList = input.split(COMMAS);

        return Arrays.asList(separatedInputList);
    }
}

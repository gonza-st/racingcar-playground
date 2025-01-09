package org.gonza.javaplayground.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Converter {

    public static final String COMMAS = ",";
    public static final int NUMBER_WHEN_NOT_SEPARATED = 1;

    public Converter() {
        throw new IllegalStateException("유틸리티 클래스는 인스턴스화 할 수 없습니다.");
    }

    public static List<String> separatedByCommas(String input) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] separatedInputList = input.split(COMMAS);

        if (separatedInputList.length == NUMBER_WHEN_NOT_SEPARATED) {
            throw new IllegalArgumentException("구분자가 올바르지 않습니다.");
        }

        arrayList.addAll(Arrays.asList(separatedInputList));

        return arrayList;
    }
}
